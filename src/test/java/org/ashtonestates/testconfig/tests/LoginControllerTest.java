/*
 * LoginControllerTest.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.testconfig.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.ashtonestates.SecurityConfiguration;
import org.ashtonestates.model.Role;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.ashtonestates.repository.UserRepository;
import org.ashtonestates.testconfig.TestWebConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Class LoginControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestWebConfig.class, SecurityConfiguration.class })
@WebAppConfiguration
public class LoginControllerTest {

	/** The Constant LOGIN_ERROR_URL. */
	private static final String LOGIN_ERROR_URL = "/login?error";

	/** The context. */
	@Autowired
	protected WebApplicationContext context;

	/** The user repo. */
	@Autowired
	private UserRepository userRepo;

	/** The mock mvc. */
	protected MockMvc mockMvc;

	final User user1 = new User("Bill", "Hunt", "password1", "1416 Bradford Ln", "william.l.hunt@gmail.com", State.APPROVED, Role.ADMIN);
	final User user2 = new User("Bill", "Walker", "password2", "1 Main Street", "bwalker@gmail.com", State.PENDING, Role.USER);
	final User user3 = new User("Stacy", "Layton", "password3", "1408 Bradford Ln", "s_layton@facebook.com", State.APPROVED, Role.USER);

	/**
	 * Setup.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();

		userRepo.save(Arrays.asList(user1, user2, user3));
	}

	/**
	 * Teardown.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void teardown() throws Exception {
		userRepo.deleteAll();
	}

	/**
	 * Test get login.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetLogin() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}

	/**
	 * Test logout get.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testLogoutGet() throws Exception {
		mockMvc.perform(get("/logout")).andExpect(status().isOk());
	}

	/**
	 * Test logout.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testLogout() throws Exception {
		mockMvc.perform(logout()).andExpect(status().isFound()).andExpect(unauthenticated());
	}

	/**
	 * Authentication failed anonymous.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithAnonymousUser
	public void authenticationFailedAnonymous() throws Exception {
		mockMvc.perform(formLogin()).andExpect(status().isFound()).andExpect(redirectedUrl(LOGIN_ERROR_URL)).andExpect(unauthenticated());
	}

	/**
	 * Authentication failed user.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser
	public void authenticationFailedUser() throws Exception {
		mockMvc.perform(formLogin()).andExpect(status().isFound()).andExpect(redirectedUrl(LOGIN_ERROR_URL)).andExpect(unauthenticated());
	}

	/**
	 * Authentication failed bad pwd.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void authenticationFailedBadPwd() throws Exception {
		mockMvc.perform(formLogin().user("email", "william.l.hunt@gmail.com").password("password", "invalid")).andExpect(status().isFound())
				.andExpect(redirectedUrl(LOGIN_ERROR_URL)).andExpect(unauthenticated());
	}

	/**
	 * Authentication failed bad user.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void authenticationFailedBadUser() throws Exception {
		mockMvc.perform(formLogin().user("email", "invalid").password("password", "invalid")).andExpect(status().isFound()).andExpect(redirectedUrl(LOGIN_ERROR_URL))
				.andExpect(unauthenticated());
	}

	/**
	 * Authentication success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void authenticationSuccess() throws Exception {
		mockMvc.perform(formLogin().user("email", "william.l.hunt@gmail.com").password("password", "password1")).andExpect(status().isFound()).andExpect(redirectedUrl("/"))
				.andExpect(authenticated().withUsername("william.l.hunt@gmail.com"));
	}
}
