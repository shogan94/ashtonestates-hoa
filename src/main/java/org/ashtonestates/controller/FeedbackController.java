/*
 *
 */
package org.ashtonestates.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.validation.Valid;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.ashtonestates.AshtonEmail;
import org.ashtonestates.model.forms.FeedbackForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FeedbackController extends BaseController {

	@PostMapping("/processFeedback")
	public String processFeedback(@Valid @ModelAttribute("feedbackForm") final FeedbackForm form, final BindingResult result, final ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
			return "residentsFeedback";
		} else {
			final HashSet<String> toEmails = new LinkedHashSet<>();

			if (form.isHomeboard()) {
				homeownerBoardRepo.findAll().forEach(obj -> toEmails.add(obj.getEmail()));
			}
			if (form.isMasterboard()) {
				masterBoardRepo.findAll().forEach(obj -> toEmails.add(obj.getEmail()));
			}
			if (form.isPresident()) {
				toEmails.add("president@ashtonestates.org");
			}
			if (form.isSecretary()) {
				toEmails.add("secretary@ashtonestates.org");
			}
			if (form.isTownboard()) {
				townhomeBoardRepo.findAll().forEach(obj -> toEmails.add(obj.getEmail()));
			}
			if (form.isTreasurer()) {
				toEmails.add("treasurer@ashtonestates.org");
			}

			if (!toEmails.isEmpty()) {

				try {
					final Email email = AshtonEmail.getInstance().getSimpleEmail();
					email.setSubject("AshtonEstates Member Feedback-Comments");
					email.addTo(toEmails.toArray(new String[] {}));
					email.setFrom(getLoggedInUser().getEmail());
					email.setMsg(form.getFeedback());
					email.send();
				} catch (final EmailException e) {
					log.error("Error sending feedback: {}", e.getMessage());
				}
			}
		}

		return "redirect:/residents";
	}

}