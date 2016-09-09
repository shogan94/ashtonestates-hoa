/*
 *
 */
package org.ashtonestates.user.model.forms;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class ResidentInfoForm {
	private Long userId;
	private String email;
	private String firstName;
	private String lastName;
	private String address;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String val) {
		firstName = StringUtils.capitalize(val);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String val) {
		lastName = StringUtils.capitalize(val);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String val) {
		address = WordUtils.capitalizeFully(val);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}
}
