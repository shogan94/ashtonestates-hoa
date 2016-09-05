/*
 *
 */
package org.ashtonestates.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.user.model.RegisterForm;
import org.ashtonestates.user.model.RoleType;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	SimpleMailMessage templateMessage;

	@Autowired
	JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(final HttpServletRequest request, final HttpServletResponse response) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(final HttpSession session, final Model model) {
		return "users/register";
	}

	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("registerForm") final RegisterForm form, final HttpSession session, final BindingResult result, final Model model) {
		String nextPage;

		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			nextPage = "users/register";
		} else {
			final User residentUser = userRepo.findByEmail(form.getEmail());
			if (residentUser != null) {
				model.addAttribute("errorMessage", "Email already registered, please login");
				nextPage = "login";
			} else {
				if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
					LOGGER.info("password not equal: {} != {}", form.getPassword(), form.getConfirmPassword());
					model.addAttribute("errorMessage", "Password and Confirm Password not equal");
					nextPage = "users/register";
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
					nextPage = "login";
				}
			}
		}

		return nextPage;
	}

	private void sendRegisterEmail(final User resident) {
		LOGGER.info("sendRegisterEmail");
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
			LOGGER.info("sending email");
			mailSender.send(msg);
			LOGGER.info("sent");
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	@RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
	public String forgotPwd(final HttpSession session, final Model model) {
		return "users/forgotPwd";
	}
}
