package org.ashtonestates.controller;

import java.util.Arrays;

import org.ashtonestates.model.Role;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController extends BaseController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/security/initData", method = RequestMethod.GET)
	public String initData() {

		userRepo.deleteAll();

		final User user1 = new User();
		user1.setFirstName("william");
		user1.setLastName("hunt");
		user1.setAddress("1416 bradford ln");
		user1.setEmail("william.l.hunt@gmail.com");
		user1.setPassword("password1");
		user1.setRole(Role.ADMIN);
		user1.setState(State.APPROVED);

		userRepo.save(Arrays.asList(user1));

		return "redirect:/";
	}

}
