package org.ashtonestates.controller;

import java.util.Arrays;

import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.RoleType;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.repository.RoleRepository;
import org.ashtonestates.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@RequestMapping(value = "/security/initData", method = RequestMethod.GET)
	public String initData() {

		userRepo.deleteAll();
		roleRepo.deleteAll();

		final Role userRole = roleRepo.save(new Role(RoleType.USER));
		final Role adminRole = roleRepo.save(new Role(RoleType.ADMIN));

		final User user1 = new User();
		user1.setFirstName("william");
		user1.setLastName("hunt");
		user1.setAddress("1416 bradford ln");
		user1.setEmail("william.l.hunt@gmail.com");
		user1.setPassword("password1");
		user1.setRole(adminRole);
		user1.setState(State.APPROVED);

		final User user2 = new User();
		user2.setFirstName("tammi");
		user2.setLastName("hunt");
		user2.setAddress("1416 bradford ln");
		user2.setEmail("tammi.hunt@gmail.com");
		user2.setPassword("password1");
		user2.setRole(adminRole);
		user2.setState(State.PENDING);

		userRepo.save(Arrays.asList(user1, user2));

		return "redirect:/";

	}

}
