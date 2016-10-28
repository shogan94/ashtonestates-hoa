/*
 * VersionController.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.controller;

import org.ashtonestates.security.VersionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class VersionController.
 */
@RestController
public class VersionController {

	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(VersionController.class);

	/**
	 * Gets the jbsadatabase web app version.
	 *
	 * @return the version
	 */
	@GetMapping("/version")
	public ResponseEntity<String> getVersion() {
		final String version = VersionUtility.getInstance().getVersion();
		LOGGER.debug("Version = {}", version);
		return new ResponseEntity<>(version, HttpStatus.OK);
	}
}
