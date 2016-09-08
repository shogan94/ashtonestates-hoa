/*
 *
 */
package org.ashtonestates.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.user.model.DocumentType;
import org.ashtonestates.user.model.Documents;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.model.forms.ChangePwdForm;
import org.ashtonestates.user.model.forms.ResidentInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	SimpleMailMessage templateMessage;

	@Autowired
	JavaMailSenderImpl mailSender;

	@GetMapping("/admin")
	public String admin(final ModelMap model) {
		final Long count = userRepo.countByState(State.PENDING);
		model.addAttribute("numberPending", count);
		return "admin/adminHome";
	}

	@GetMapping("/admin/editDocs")
	public String editDocs(final ModelMap model) {
		return "admin/editDocs";
	}

	@GetMapping("/admin/editHomeDocs")
	public String editHomeDocs(final ModelMap model) {
		model.addAttribute("homePublicFiles", docRepo.findByDocumentType(DocumentType.PUBLIC_HOMES));
		model.addAttribute("homeResidentFiles", docRepo.findByDocumentType(DocumentType.RESIDENT_HOMES));
		return "admin/editHomeDocs";
	}

	@GetMapping("/admin/deleteHomeDoc/{id}")
	public String deleteHomeDoc(@PathVariable final String id, final ModelMap model) {
		deleteDoc(id);
		return editHomeDocs(model);
	}

	@GetMapping("/admin/editTownhomeDocs")
	public String editTownhomeDocs(final ModelMap model) {
		model.addAttribute("townhomePublicFiles", docRepo.findByDocumentType(DocumentType.PUBLIC_TOWNHOME));
		model.addAttribute("townhomeResidentFiles", docRepo.findByDocumentType(DocumentType.RESIDENT_TOWNHOME));
		return "admin/editTownhomeDocs";
	}

	@GetMapping("/admin/deleteTownhomeDoc/{id}")
	public String deleteTownhomeDoc(@PathVariable final String id, final ModelMap model) {
		deleteDoc(id);
		return editTownhomeDocs(model);
	}

	@GetMapping("/admin/approvePending")
	public String approvePending(final ModelMap model) {
		final List<User> pendingUsers = userRepo.findByState(State.PENDING);
		model.addAttribute("pendingUsers", pendingUsers);
		return "admin/approvePending";
	}

	@GetMapping("/admin/approve/{userId}")
	public String approve(@PathVariable final String userId, final ModelMap model) {
		final String approver = getPrincipal();

		final User user = userRepo.findOne(Long.parseLong(userId));
		user.setState(State.APPROVED);
		user.setApprovedBy(approver);
		userRepo.save(user);

		sendApprovedMessage(user);
		return approvePending(model);
	}

	@GetMapping("/admin/reject/{userId}")
	public String reject(@PathVariable final String userId, final ModelMap model) {
		final User user = userRepo.findOne(Long.parseLong(userId));
		userRepo.delete(Long.parseLong(userId));
		sendRejectMessage(user);

		return approvePending(model);
	}

	@GetMapping("/admin/editUsers")
	public String editUsers(final ModelMap model) {
		final List<User> users = userRepo.findByState(State.APPROVED);
		model.addAttribute("users", users);
		return "admin/editUsers";
	}

	@GetMapping("/admin/removeUser/{userId}")
	public String adminRemoveUser(@PathVariable final String userId, final ModelMap model) {
		userRepo.delete(Long.parseLong(userId));
		return editUsers(model);
	}

	@GetMapping("/admin/editUser/{userId}")
	public String adminEditUser(@PathVariable final String userId, final ModelMap model) {
		final User changeUser = userRepo.findOne(Long.parseLong(userId));
		model.addAttribute("userFN", changeUser.getFirstName());
		model.addAttribute("userLN", changeUser.getLastName());

		final ResidentInfoForm form = new ResidentInfoForm();
		form.setUserId(Long.parseLong(userId));
		form.setAddress(changeUser.getAddress());
		form.setEmail(changeUser.getEmail());
		form.setFirstName(changeUser.getFirstName());
		form.setLastName(changeUser.getLastName());
		model.addAttribute("residentInfoForm", form);

		return "admin/editUser";
	}

	@PostMapping("/admin/processUpdateInfo")
	public String adminProcessUpdateInfo(@Valid @ModelAttribute("residentInfoForm") final ResidentInfoForm form, final BindingResult result, final ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return adminEditUser(form.getUserId().toString(), model);
		} else {
			final User user = userRepo.findOne(form.getUserId());
			final User existing = userRepo.findByEmail(form.getEmail());
			if (user.getEmail().equals(form.getEmail()) || existing == null) {
				user.setEmail(form.getEmail());
				user.setAddress(form.getAddress());
				user.setFirstName(form.getFirstName());
				user.setLastName(form.getLastName());
				userRepo.save(user);
			} else {
				model.addAttribute("errorMessage", "This email already exists in the system");
				return adminEditUser(form.getUserId().toString(), model);
			}
		}

		return editUsers(model);
	}

	@GetMapping("/admin/changePwd/{userId}")
	public String adminChangePwd(@PathVariable final String userId, final ModelMap model) {
		final User user = getLoggedInUser();
		model.addAttribute("residentUser", user);
		model.addAttribute("userId", userId);

		final User changeUser = userRepo.findOne(Long.parseLong(userId));
		model.addAttribute("userFN", changeUser.getFirstName());
		model.addAttribute("userLN", changeUser.getLastName());
		return "admin/changePwd";
	}

	@PostMapping("/admin/processChangePwd")
	public String adminProcessChangePwd(@Valid @ModelAttribute("changePwdForm") final ChangePwdForm form, final BindingResult result, final ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return adminChangePwd(form.getUserId().toString(), model);
		} else {
			final User residentUser = userRepo.findOne(form.getUserId());
			if (residentUser == null) {
				model.addAttribute("errorMessage", "User not found but should have been.");
				return editUsers(model);
			} else {
				if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
					model.addAttribute("errorMessage", "Password and Confirm Password not equal");
					return adminChangePwd(form.getUserId().toString(), model);
				} else {
					residentUser.setPassword(form.getPassword());
					userRepo.save(residentUser);

					sendChangePwdMessage(residentUser, form.getPassword());
				}
			}
		}

		return editUsers(model);
	}

	private void sendRejectMessage(final User user) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(user.getEmail());
		msg.setSubject("Ashton Estates WebSite Registration Status");

		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been rejected by an admin.\nPlease re-register or contact a board member for assistance.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	private void sendApprovedMessage(final User user) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(user.getEmail());
		msg.setSubject("Ashton Estates WebSite Registration Status");

		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been approved by an admin.\nYou may now access the 'Residents' section of the website.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	private void sendChangePwdMessage(final User user, final String pwd) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(user.getEmail());
		msg.setSubject("Ashton Estates WebSite Password");

		final String message = String.format(
				"Dear %s %s, \n\nYour password on the Ashton Estates web site has been changed by an admin.\nYou should login with the following information.\n"
						+ "Email: %s\nPassword: %s\n\n" + "After you login, you can access the 'Residents' section and click on 'Change Password' to change it.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), user.getEmail(), pwd, new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	private void deleteDoc(final String id) {
		final Documents doc = docRepo.findOne(Long.parseLong(id));
		FileUtils.deleteQuietly(new File(doc.getPath()));
		docRepo.delete(Long.parseLong(id));
		docRepo.flush();
	}
}