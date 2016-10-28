/*
 * VersionUtility.java
 * Copyright (c) 2016, clearAvenue, LLC. jbsadatabase
 * All rights reserved.
 */
package org.ashtonestates.security;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class VersionUtility.
 */
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
		return StringUtils.defaultIfBlank(this.getClass().getPackage().getImplementationVersion(), "No version detected");
	}
}
