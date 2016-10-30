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
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.ashtonestates.model.DocumentType;
import org.ashtonestates.model.Documents;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.ashtonestates.model.forms.ChangePwdForm;
import org.ashtonestates.model.forms.ResidentInfoForm;
import org.ashtonestates.security.AshtonEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController extends BaseController {

	@GetMapping("/admin")
	public String admin(final ModelMap model) {
		final Long count = userRepo.countByState(State.PENDING);
		model.addAttribute("numberPending", count);
		return "adminHome";
	}

	@GetMapping("/admin/editDocs")
	public String editDocs() {
		return "adminEditDocs";
	}

	@GetMapping("/admin/editHomeDocs")
	public String editHomeDocs(final ModelMap model) {
		model.addAttribute("homePublicFiles", docRepo.findByDocumentType(DocumentType.PUBLIC_HOMES));
		model.addAttribute("homeResidentFiles", docRepo.findByDocumentType(DocumentType.RESIDENT_HOMES));
		return "adminEditHomeDocs";
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
		return "adminEditTownhomeDocs";
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
		return "adminApprovePending";
	}

	@GetMapping("/admin/approve/{userId}")
	public String approve(@PathVariable final String userId, final ModelMap model) {
		final String approver = getPrincipal();

		final User user = userRepo.findOne(Long.parseLong(userId));
		user.setState(State.APPROVED);
		user.setApprovedBy(approver);
		userRepo.save(user);

		try {
			sendApprovedMessage(user);
		} catch (final EmailException e) {
			log.error("Unable to send approve email: {}", e.getMessage());
		}
		return approvePending(model);
	}

	@GetMapping("/admin/reject/{userId}")
	public String reject(@PathVariable final String userId, final ModelMap model) {
		final User user = userRepo.findOne(Long.parseLong(userId));
		userRepo.delete(Long.parseLong(userId));

		try {
			sendRejectMessage(user);
		} catch (final EmailException e) {
			log.error("Unable to send reject email: {}", e.getMessage());
		}

		return approvePending(model);
	}

	@GetMapping("/admin/editUsers")
	public String editUsers(final ModelMap model) {
		final List<User> users = userRepo.findByState(State.APPROVED);
		model.addAttribute("users", users);
		return "adminEditUsers";
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
		form.setRole(changeUser.getRole());
		model.addAttribute("residentInfoForm", form);

		return "adminEditUser";
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
				user.setRole(form.getRole());
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
		return "adminChangePwd";
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

					try {
						sendChangePwdMessage(residentUser, form.getPassword());
					} catch (final EmailException e) {
						log.error("Unable to send change pwd email: {}", e.getMessage());
					}
				}
			}
		}

		return editUsers(model);
	}

	private void sendRejectMessage(final User user) throws EmailException {
		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been rejected by an admin.\nPlease re-register or contact a board member for assistance.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());

		final Email email = AshtonEmail.getInstance().getSimpleEmail();
		email.addTo(user.getEmail());
		email.setSubject("Ashton Estates WebSite Registration Status");
		email.setMsg(message);
		email.send();
	}

	private void sendApprovedMessage(final User user) throws EmailException {
		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been approved by an admin.\nYou may now access the 'Residents' section of the website.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());

		final Email email = AshtonEmail.getInstance().getSimpleEmail();
		email.addTo(user.getEmail());
		email.setSubject("Ashton Estates WebSite Registration Status");
		email.setMsg(message);
		email.send();
	}

	private void sendChangePwdMessage(final User user, final String pwd) throws EmailException {
		final String message = String.format(
				"Dear %s %s, \n\nYour password on the Ashton Estates web site has been changed by an admin.\nYou should login with the following information.\n"
						+ "Email: %s\nPassword: %s\n\n" + "After you login, you can access the 'Residents' section and click on 'Change Password' to change it.\n\n"
						+ "Thank you,\nAshton Estates Webmaster\n\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), user.getEmail(), pwd, new Date().toString());

		final Email email = AshtonEmail.getInstance().getSimpleEmail();
		email.addTo(user.getEmail());
		email.setSubject("Ashton Estates WebSite Password");
		email.setMsg(message);
		email.send();
	}

	private void deleteDoc(final String id) {
		final Documents doc = docRepo.findOne(Long.parseLong(id));
		FileUtils.deleteQuietly(new File(doc.getPath()));
		docRepo.delete(Long.parseLong(id));
		docRepo.flush();
	}
}