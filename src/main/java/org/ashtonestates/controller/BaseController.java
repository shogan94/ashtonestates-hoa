package org.ashtonestates.controller;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.model.User;
import org.ashtonestates.repository.DocumentsRepository;
import org.ashtonestates.repository.HomeOwnerBoardRepository;
import org.ashtonestates.repository.MasterBoardRepository;
import org.ashtonestates.repository.ResetRequestRepository;
import org.ashtonestates.repository.TownhomeBoardRepository;
import org.ashtonestates.repository.UpcomingEventsRepository;
import org.ashtonestates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UpcomingEventsRepository eventsRepo;

	@Autowired
	DocumentsRepository docRepo;

	@Autowired
	ResetRequestRepository resetRepo;

	@Autowired
	HomeOwnerBoardRepository homeownerBoardRepo;

	@Autowired
	TownhomeBoardRepository townhomeBoardRepo;

	@Autowired
	MasterBoardRepository masterBoardRepo;

	protected String getPrincipal() {
		String userName = StringUtils.EMPTY;

		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			final String email = ((UserDetails) principal).getUsername();
			final User user = userRepo.findByEmail(email);
			userName = String.format("%s %s", user.getFirstName(), user.getLastName());
		} else {
			userName = principal.toString();
		}

		return userName;
	}

	protected User getLoggedInUser() {

		User user = null;

		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			final String email = ((UserDetails) principal).getUsername();
			user = userRepo.findByEmail(email);
		}

		return user;
	}

}
