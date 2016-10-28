/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ashtonestates.model.DocumentType;
import org.ashtonestates.model.UpcomingEvents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {

	@GetMapping("/")
	public String home(final ModelMap model) {
		return "home";
	}

	@GetMapping("/faq")
	public String faq(final ModelMap model) {
		return "faq";
	}

	@GetMapping("/upcomingEvents")
	public String upcomingEvents(final ModelMap model) {
		final List<UpcomingEvents> events = eventsRepo.findAll();
		model.addAttribute("events", events);
		return "upcomingEvents";
	}

	@GetMapping("/pendingApproval")
	public String pendingApproval(final ModelMap model) {
		return "pendingApproval";
	}

	@GetMapping("/publicDocs")
	public String showPublicDocs(final HttpSession session, final ModelMap model) {
		model.addAttribute("typeofdocs", "Public");
		model.addAttribute("townhomeTypePath", "townhome-public-docs");
		model.addAttribute("townhomeFiles", docRepo.findByDocumentType(DocumentType.PUBLIC_TOWNHOME));
		model.addAttribute("homeTypePath", "home-public-docs");
		model.addAttribute("homeFiles", docRepo.findByDocumentType(DocumentType.PUBLIC_HOMES));
		return "publicDocuments";
	}

}
