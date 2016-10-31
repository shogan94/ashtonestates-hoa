/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.model.DocumentType;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.ashtonestates.model.forms.ChangePwdForm;
import org.ashtonestates.model.forms.ResidentInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResidentsController extends BaseController {

	@GetMapping("/residents/changePwd")
	public String residentsChangePwd(final ModelMap model) {
		return "residentsChangePwd";
	}

	@PostMapping("/residents/processChangePwd")
	public String residentProcessChangePwd(@Valid @ModelAttribute("changePwdForm") final ChangePwdForm form, final BindingResult result, final ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return residentsChangePwd(model);
		} else {
			final User residentUser = getLoggedInUser();
			if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
				model.addAttribute("errorMessage", "Password and Confirm Password not equal");
				return residentsChangePwd(model);
			} else {
				residentUser.setPassword(form.getPassword());
				userRepo.save(residentUser);
			}
		}

		return "redirect:/logout";
	}

	@GetMapping("/residents/updateInfo")
	public String residentsUpdateInfo(final ModelMap model) {
		final User residentUser = getLoggedInUser();

		final ResidentInfoForm form = new ResidentInfoForm();
		form.setAddress(residentUser.getAddress());
		form.setEmail(residentUser.getEmail());
		form.setFirstName(residentUser.getFirstName());
		form.setLastName(residentUser.getLastName());
		form.setPhone(residentUser.getPhone());

		model.addAttribute("residentInfoForm", form);
		return "residentsUpdateInfo";
	}

	@PostMapping("/residents/processUpdateInfo")
	public String residentProcessUpdateInfo(@Valid @ModelAttribute("residentInfoForm") final ResidentInfoForm form, final BindingResult result, final ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return residentsUpdateInfo(model);
		} else {
			final User residentUser = getLoggedInUser();
			final User existing = userRepo.findByEmail(form.getEmail());
			if (residentUser.getEmail().equals(form.getEmail()) || existing == null) {
				residentUser.setEmail(form.getEmail());
				residentUser.setAddress(form.getAddress());
				residentUser.setFirstName(form.getFirstName());
				residentUser.setLastName(form.getLastName());
				residentUser.setPhone(form.getPhone());
				userRepo.save(residentUser);
			} else {
				model.addAttribute("errorMessage", "This email already exists in the system");
				return residentsUpdateInfo(model);
			}
		}

		return residents();
	}

	@GetMapping("/residents")
	public String residents() {
		return "residentsHome";
	}

	@GetMapping("/residents/directory")
	public String showDirectory(final ModelMap model) {
		model.addAttribute("users", getAllUsers());
		return "residentsDirectory";
	}

	@GetMapping("/residents/documents")
	public String showDocuments(final ModelMap model) {
		model.addAttribute("typeofdocs", "Resident");
		model.addAttribute("townhomeTypePath", "townhome-resident-docs");
		model.addAttribute("townhomeFiles", docRepo.findByDocumentType(DocumentType.RESIDENT_TOWNHOME));
		model.addAttribute("homeTypePath", "home-resident-docs");
		model.addAttribute("homeFiles", docRepo.findByDocumentType(DocumentType.RESIDENT_HOMES));

		return "residentsDocuments";
	}

	@GetMapping("/residents/boardMembers")
	public String boardMembers() {
		return "residentsBoardMembers";
	}

	@GetMapping("/residents/feedback")
	public String feedback() {
		return "residentsFeedback";
	}

	private List<User> getAllUsers() {
		final List<User> users = userRepo.findByState(State.APPROVED);
		return users;
	}
}
