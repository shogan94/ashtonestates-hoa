/*
 *
 */
package org.ashtonestates;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(30 * 60);
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {

	}

}
