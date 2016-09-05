/*
 *
 */
package org.ashtonestates.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	SimpleMailMessage templateMessage;

	@Autowired
	JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(final HttpSession session, final Model model) {
		String nextPage;

		final Long count = userRepo.countByState(State.PENDING);
		model.addAttribute("numberPending", count);
		nextPage = "admin/adminhome";

		return nextPage;
	}

	@RequestMapping(value = "/admin/approvePending", method = RequestMethod.GET)
	public String approvePending(final HttpSession session, final Model model) {
		String nextPage;

		final List<User> pendingUsers = userRepo.findByState(State.PENDING);
		model.addAttribute("pendingUsers", pendingUsers);
		nextPage = "admin/approvePending";

		return nextPage;
	}

	@RequestMapping(value = "/admin/editUsers", method = RequestMethod.GET)
	public String editUsers(final HttpSession session, final Model model) {
		String nextPage;

		final List<User> users = userRepo.findByState(State.APPROVED);
		model.addAttribute("users", users);
		nextPage = "admin/editUsers";

		return nextPage;
	}

	@RequestMapping(value = "/admin/approve/{userId}", method = RequestMethod.GET)
	public String approve(@PathVariable final String userId, final HttpSession session, final Model model) {
		LOGGER.info("approve {}", userId);

		String nextPage;

		final String approver = getPrincipal();

		final User user = userRepo.findOne(Long.parseLong(userId));
		user.setState(State.APPROVED);
		user.setApprovedBy(approver);

		userRepo.save(user);

		sendApprovedMessage(user);

		final List<User> pendingUsers = userRepo.findByState(State.PENDING);
		model.addAttribute("pendingUsers", pendingUsers);
		nextPage = "admin/approvePending";

		return nextPage;
	}

	@RequestMapping(value = "/admin/reject/{userId}", method = RequestMethod.GET)
	public String reject(@PathVariable final String userId, final HttpSession session, final Model model) {
		LOGGER.info("reject {}", userId);

		String nextPage;

		final User user = userRepo.findOne(Long.parseLong(userId));
		userRepo.delete(Long.parseLong(userId));
		sendRejectMessage(user);

		final List<User> pendingUsers = userRepo.findByState(State.PENDING);
		model.addAttribute("pendingUsers", pendingUsers);
		nextPage = "admin/approvePending";

		return nextPage;
	}

	private void sendRejectMessage(final User user) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(user.getEmail());
		msg.setSubject("Ashton Estates WebSite Registration Status");

		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been rejected by an admin.\nPlease re-register or contact a board member for assistance.\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	private void sendApprovedMessage(final User user) {
		final SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(user.getEmail());
		msg.setSubject("Ashton Estates WebSite Registration Status");

		final String message = String.format(
				"Dear %s %s, \n\nYour registering on the Ashton Estates web site has been approved by an admin.\nYou may now access the 'Residents' section of the website.\n"
						+ "Thank you,\nAshton Estates Webmaster\n%s",
				StringUtils.capitalize(user.getFirstName()), StringUtils.capitalize(user.getLastName()), new Date().toString());
		msg.setText(message);
		try {
			mailSender.send(msg);
		} catch (final MailException ex) {
			LOGGER.info(ex.getMessage());
		}
	}
}