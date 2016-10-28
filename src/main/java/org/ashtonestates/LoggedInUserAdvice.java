package org.ashtonestates;

import java.security.Principal;

import org.ashtonestates.model.User;
import org.ashtonestates.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LoggedInUserAdvice {

	@Autowired
	UserRepository userRepo;

	@ModelAttribute("loggedInUserName")
	public String loggedInUserName(final Principal principal) {
		String result = null;

		if (principal != null) {

			final String name = principal.getName();
			final User user = userRepo.findByEmail(name);

			if (user != null) {
				result = String.format("%s %s", user.getFirstName(), user.getLastName());
			}
		}

		return result;
	}
}