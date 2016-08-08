package org.ashtonestates.controller;

import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.RoleType;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.repository.RoleRepository;
import org.ashtonestates.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackdoorController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@RequestMapping(value = "/backdoor/init", method = RequestMethod.GET)
	public void backdoor() {

		userRepo.deleteAll();
		roleRepo.deleteAll();

		roleRepo.save(new Role(RoleType.USER));
		final Role adminRole = roleRepo.save(new Role(RoleType.ADMIN));

		final User user = new User();
		user.setFirstName("william");
		user.setLastName("hunt");
		user.setAddress("1416 bradford ln");
		user.setEmail("william.l.hunt@gmail.com");
		user.setPassword("password1");
		user.setRole(adminRole);
		user.setState(State.APPROVED);

		userRepo.save(user);

	}

}
