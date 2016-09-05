/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.ashtonestates.utils.AshtonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResidentsController extends BaseController {

	@RequestMapping(value = "/residents", method = RequestMethod.GET)
	public String residents(final HttpSession session, final Model model) {
		return "residents/residents";
	}

	@RequestMapping(value = "/directory", method = RequestMethod.GET)
	public String showDirectory(final HttpSession session, final Model model) {
		String nextPage = "";

		final User residentUser = getLoggedInUser();

		if (residentUser.getState() == State.PENDING) {
			model.addAttribute("firstname", residentUser.getFirstName());
			model.addAttribute("lastname", residentUser.getLastName());
			nextPage = "users/pendingApproval";
		} else {
			model.addAttribute("users", getAllUsers());
			nextPage = "residents/directory";
		}
		return nextPage;
	}

	private List<User> getAllUsers() {
		final List<User> users = userRepo.findByState(State.APPROVED);
		return users;
	}

	@RequestMapping(value = "/resident-documents", method = RequestMethod.GET)
	public String showDocuments(final HttpSession session, final Model model) {
		String nextPage = "";

		final User residentUser = getLoggedInUser();

		if (residentUser.getState() == State.PENDING) {
			model.addAttribute("firstname", residentUser.getFirstName());
			model.addAttribute("lastname", residentUser.getLastName());
			nextPage = "users/pendingApproval";
		} else {
			model.addAttribute("typeofdocs", "Resident");
			if (residentUser.isTownhouseUser()) {
				model.addAttribute("typePath", "townhome-resident-docs");
				model.addAttribute("files", AshtonUtils.getFileListing(session, "/townhome-resident-docs"));
			} else {
				model.addAttribute("typePath", "home-resident-docs");
				model.addAttribute("files", AshtonUtils.getFileListing(session, "/home-resident-docs"));
			}

			nextPage = "documents";
		}
		return nextPage;
	}
}
