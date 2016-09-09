/*
 *
 */
package org.ashtonestates.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.ashtonestates.user.model.ResetRequest;
import org.ashtonestates.user.model.RoleType;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.model.forms.ChangePwdForm;
import org.ashtonestates.user.model.forms.RegisterForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	SimpleMailMessage templateMessage;

	@Autowired
	JavaMailSenderImpl mailSender;

	@GetMapping("/login")
	public String login(final ModelMap model) {
		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage(final HttpServletRequest request, final HttpServletResponse response) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@GetMapping("/forgotPwd")
	public String forgotPwd(final ModelMap model) {
		return "forgotPwd";
	}

	@PostMapping("/processForgotPwd")
	public String processForgotPwd(@RequestParam("email") final String email, final ModelMap model) {
		final User user = userRepo.findByEmail(email);
		if (user != null) {
			ResetRequest existing = resetRepo.findByUser(user);
			if (existing != null) {
				existing.setRequestId(createRandomRequestId());
			} else {
				existing = new ResetRequest();
				existing.setRequestId(createRandomRequestId());
				existing.setUser(user);
			}

			final int addMinuteTime = 60;
			Date expires = new Date();
			expires = DateUtils.addMinutes(expires, addMinuteTime);
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			existing.setExpires(sdf.format(expires));
			resetRepo.save(existing);

			sendForgotPwdEmail(existing);
		}

		return "forgotPwdComplete";
	}

	@GetMapping("/reset/{requestId}")
	public String resetPwd(@PathVariable final String requestId, final ModelMap model) {
		final ResetRequest req = resetRepo.findByRequestId(requestId);
		if (req == null) {
			model.addAttribute("errorMessage", "Reset Request not found");
			return login(model);
		} else {
			final Date now = new Date();
			Date expires = new Date();
			try {
				expires = DateUtils.parseDate(req.getExpires(), "yyyy-MM-dd HH:mm:ss");
			} catch (final ParseException e) {
				LOGGER.info("Parse date error: {}", e.getMessage());
			}

			if (now.after(expires)) {
				model.addAttribute("errorMessage", "Reset Request has expired, please submit a new request");
				return forgotPwd(model);
			} else {
				final ChangePwdForm form = new ChangePwdForm();
				form.setUserId(req.getUser().getId());
				model.addAttribute("changePwdForm", form);
			}
		}

		return "resetPwd";
	}

	@PostMapping("/processResetPwd")
	public String processResetPwd(@Valid @ModelAttribute("changePwdForm") final ChangePwdForm form, final BindingResult result, final ModelMap model) {
		final User user = userRepo.findOne(form.getUserId());
		final ResetRequest req = resetRepo.findByUser(user);
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return resetPwd(req.getRequestId(), model);
		} else {
			final User residentUser = userRepo.findOne(form.getUserId());
			if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
				model.addAttribute("errorMessage", "Password and Confirm Password not equal");
				return resetPwd(req.getRequestId(), model);
			} else {
				residentUser.setPassword(form.getPassword());
				userRepo.save(residentUser);

				final ResetRequest reset = resetRepo.findByUser(residentUser);
				resetRepo.delete(reset.getId());
			}
		}

		return "home";
	}

	@GetMapping("/register")
	public String register(final ModelMap model) {
		return "register";
	}

	@PostMapping("/processRegistration")
	public String registerUser(@Valid @ModelAttribute("registerForm") final RegisterForm form, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return register(model);
		} else {
			final User residentUser = userRepo.findByEmail(form.getEmail());
			if (residentUser != null) {
				model.addAttribute("errorMessage", "Email already registered, please login");
			} else {
				if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
					LOGGER.info("password not equal: {} != {}", form.getPassword(), form.getConfirmPassword());
					model.addAttribute("errorMessage", "Password and Confirm Password not equal");
					return register(model);
				} else {
					final User resident = new User();
					resident.setEmail(form.getEmail());
					resident.setFirstName(form.getFirstName());
					resident.setLastName(form.getLastName());
					resident.setPassword(form.getPassword());
					resident.setRole(roleRepo.findByType(RoleType.USER));
					resident.setState(State.PENDING);
					resident.setAddress(form.getAddress());
					userRepo.save(resident);

					sendRegisterEmail(resident);

					model.addAttribute("errorMessage", "Registration submitted, please check your email for additional information.");
				}
			}
		}

		return login(model);
	}

	private String createRandomRequestId() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	private void sendForgotPwdEmail(final ResetRequest request) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(request.getUser().getEmail());
		msg.setSubject("Ashton Estates Website Password Reset");

		final String message = String.format(
				"Dear %s, \n\nYou recently requested to reset your password for your Ashton Estates Website account. Click the link below to reset it.\n\n"
						+ "http://localhost:8080/ashtonestates/reset/%s\n\n"
						+ "If you did not request a password reset, please ignore this email or reply to let us know. This password reset is only valid for the next 30 minutes.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(request.getUser().getFirstName()), request.getRequestId(), request.getRequestId(), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	private void sendRegisterEmail(final User resident) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(resident.getEmail());
		msg.setSubject("Ashton Estates Website Registration Submitted");

		final String message = String.format(
				"Dear %s %s, \n\nThank you for registering on the Ashton Estates web site.\nYour registration is pending approval by an admin.\n"
						+ "You will receive another email when your registration has been approved.\n"
						+ "If you have not received approval within 3 days, please contact a board member for assistance.\n\n" + "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(resident.getFirstName()), StringUtils.capitalize(resident.getLastName()), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

}
