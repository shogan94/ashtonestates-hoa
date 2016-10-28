package org.ashtonestates.security;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class AshtonEmail {

	/** The instance. */
	private static AshtonEmail instance;

	private static Email emailInstance;

	/**
	 * Instantiates a new version utility.
	 */
	private AshtonEmail() {
	}

	/**
	 * Gets the single instance of VersionUtility.
	 *
	 * @return single instance of VersionUtility
	 */
	public static AshtonEmail getInstance() {
		if (instance == null) {
			synchronized (AshtonEmail.class) {
				if (instance == null) {
					instance = new AshtonEmail();
				}
			}
		}

		return instance;
	}

	public Email getSimpleEmail() throws EmailException {
		if (emailInstance == null) {
			synchronized (Email.class) {
				if (emailInstance == null) {
					emailInstance = new SimpleEmail();
					emailInstance.setHostName("jdz5.dailyrazor.com");
					emailInstance.setSmtpPort(465);
					emailInstance.setAuthenticator(new DefaultAuthenticator("webmaster@ashtonestates.org", "AssSnakeHat#1"));
					emailInstance.setSSLOnConnect(true);
					emailInstance.setFrom("webmaster@ashtonestates.org");
				}
			}
		}
		return emailInstance;
	}

}
