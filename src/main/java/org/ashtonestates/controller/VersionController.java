/*
 * VersionController.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.controller;

import org.ashtonestates.model.User;
import org.ashtonestates.security.VersionUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class VersionController.
 */
@RestController
@Slf4j
public class VersionController extends BaseController {

	/**
	 * Gets the jbsadatabase web app version.
	 *
	 * @return the version
	 */
	@GetMapping("/version")
	public ResponseEntity<String> getVersion() {
		final String version = VersionUtility.getInstance().getVersion();
		log.debug("Version = {}", version);
		return new ResponseEntity<>(version, HttpStatus.OK);
	}

	@GetMapping("/residents/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable final String id, final ModelMap model) {
		return new ResponseEntity<>(userRepo.findOne(Long.parseLong(id)), HttpStatus.OK);

	}
}
