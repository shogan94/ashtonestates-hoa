/*
 *
 */
package org.ashtonestates.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.user.model.UpcomingEvents;
import org.ashtonestates.user.model.forms.EventForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController extends BaseController {

	@GetMapping("/admin/editEvents")
	public String editEvents(final ModelMap model) {
		final List<UpcomingEvents> events = eventsRepo.findAll();
		model.addAttribute("events", events);
		return "admin/editEvents";
	}

	@GetMapping("/admin/addEvent")
	public String addEvent(final ModelMap model) {
		return "admin/eventForm";
	}

	@GetMapping("/admin/editEvent/{id}")
	public String editEvent(@PathVariable final String id, final ModelMap model) {
		final UpcomingEvents modifyEvent = eventsRepo.findOne(Long.parseLong(id));
		model.addAttribute("modifyEvent", modifyEvent);
		return "admin/eventForm";
	}

	@GetMapping("/admin/removeEvent/{id}")
	public String removeEvent(@PathVariable final String id, final ModelMap model) {
		eventsRepo.delete(Long.parseLong(id));
		return editEvents(model);
	}

	@PostMapping("/admin/processEvent")
	public String registerUser(@Valid @ModelAttribute("eventForm") final EventForm form, final BindingResult result, final ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("errorMessage", result.getAllErrors().toString());
		} else {
			final UpcomingEvents event = StringUtils.isNotBlank(form.getId()) ? eventsRepo.findOne(Long.valueOf(form.getId())) : new UpcomingEvents();
			event.setTitle(form.getTitle());
			event.setEventDate(form.getEventDate());
			event.setDescription(form.getDescription());
			eventsRepo.save(event);
		}

		return editEvents(model);
	}
}