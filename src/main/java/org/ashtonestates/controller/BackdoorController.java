package org.ashtonestates.controller;

import org.ashtonestates.user.model.AshtonStatus;
import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackdoorController {

	private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "/admin/addUser/{firstname}/{lastname}/{password}/{email}/{address}", method = RequestMethod.GET)
	public void addUser(@PathVariable final String firstname, @PathVariable final String lastname, @PathVariable final String password, @PathVariable final String email,
			@PathVariable final String address) {
		LOGGER.info("adding {}/{}/{}/{}/{}", firstname, lastname, password, email, address);
		final User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setStreetAddress(address);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(Role.ROLE_ADMIN);
		user.setStatus(AshtonStatus.APPROVED);

		userRepo.save(user);
	}

}
