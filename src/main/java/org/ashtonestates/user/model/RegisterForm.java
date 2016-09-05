/*
 *
 */
package org.ashtonestates.user.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class RegisterForm {
	private String email;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String address;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String val) {
		password = val;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(final String val) {
		confirmPassword = val;
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
}
