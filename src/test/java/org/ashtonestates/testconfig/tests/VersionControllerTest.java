/*
 * VersionControllerTest.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.testconfig.tests;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.ashtonestates.SecurityConfiguration;
import org.ashtonestates.controller.VersionController;
import org.ashtonestates.testconfig.TestWebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Class VersionControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestWebConfig.class, SecurityConfiguration.class, VersionController.class })
@WebAppConfiguration
public class VersionControllerTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The controller. */
	@InjectMocks
	VersionController controller;

	/**
	 * Setup.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
	}

	/**
	 * Gets the version.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void getVersion() throws Exception {
		mockMvc.perform(get("/version")).andExpect(status().isOk());
	}
}
