/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ashtonestates.user.model.UpcomingEvents;
import org.ashtonestates.user.model.User;
import org.ashtonestates.utils.AshtonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Model model) {
		LOGGER.info("getting logged in user");
		final User user = getLoggedInUser();
		LOGGER.info("adding user: {}", user);
		model.addAttribute("residentUser", user);
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

	@RequestMapping(value = "/pendingApproval", method = RequestMethod.GET)
	public String pendingApproval(final Model model) {
		return "users/pendingApproval";
	}

	@RequestMapping(value = "/publicDocs", method = RequestMethod.GET)
	public String showPublicDocs(final HttpSession session, final Model model) {
		String nextPage;

		model.addAttribute("typeofdocs", "Public");
		model.addAttribute("townhomeTypePath", "townhome-public-docs");
		model.addAttribute("townhomeFiles", AshtonUtils.getFileListing(session, "/townhome-public-docs"));
		model.addAttribute("homeTypePath", "home-public-docs");
		model.addAttribute("homeFiles", AshtonUtils.getFileListing(session, "/home-public-docs"));

		nextPage = "publicDocuments";
		return nextPage;
	}

}
