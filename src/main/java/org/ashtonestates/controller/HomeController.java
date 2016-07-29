/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ashtonestates.user.model.UpcomingEvents;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.repository.UpcomingEventsRepository;
import org.ashtonestates.utils.AshtonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	UpcomingEventsRepository eventsRepo;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Model model) {
		return "home";
	}

	/**
	 * Selects the faq page
	 */
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq(final Model model) {
		return "faq";
	}

	@RequestMapping(value = "/upcomingEvents", method = RequestMethod.GET)
	public String upcomingEvents(final Model model) {
		final List<UpcomingEvents> events = eventsRepo.findAll();
		model.addAttribute("events", events);
		return "upcomingEvents";
	}

	@RequestMapping(value = "/publicDocs", method = RequestMethod.GET)
	public String showPublicDocs(final HttpSession session, final Model model) {
		String nextPage;

		final User residentUser = (User) session.getAttribute("residentUser");
		if (residentUser != null) {
			model.addAttribute("residentUser", residentUser);
		}

		model.addAttribute("typeofdocs", "Public");
		model.addAttribute("townhomeTypePath", "townhome-public-docs");
		model.addAttribute("townhomeFiles", AshtonUtils.getFileListing(session, "/townhome-public-docs"));
		model.addAttribute("homeTypePath", "home-public-docs");
		model.addAttribute("homeFiles", AshtonUtils.getFileListing(session, "/home-public-docs"));

		nextPage = "publicDocuments";
		return nextPage;
	}

}
