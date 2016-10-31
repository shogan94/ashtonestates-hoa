/*
 * VersionUtility.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class VersionUtility.
 */
@Slf4j
public class VersionUtility {

	/** The instance. */
	private static VersionUtility instance;

	/**
	 * Instantiates a new version utility.
	 */
	private VersionUtility() {
	}

	/**
	 * Gets the single instance of VersionUtility.
	 *
	 * @return single instance of VersionUtility
	 */
	public static VersionUtility getInstance() {
		if (instance == null) {
			synchronized (VersionUtility.class) {
				if (instance == null) {
					instance = new VersionUtility();
				}
			}
		}

		return instance;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		final ClassPathResource resource = new ClassPathResource("version.properties");
		final Properties mavenProperties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = resource.getInputStream();
			mavenProperties.load(inputStream);
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				inputStream.close();
			} catch (final IOException e) {
			}
		}

		final String version = (String) mavenProperties.get("version");
		return StringUtils.defaultIfBlank(version, "No version detected");
	}
}
