/*
 *
 */
package org.ashtonestates.model.forms;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import lombok.Getter;
import lombok.Setter;

public class RegisterForm {
	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String confirmPassword;

	@Getter
	private String firstName;

	public void setFirstName(final String val) {
		firstName = StringUtils.capitalize(val);
	}

	@Getter
	private String lastName;

	public void setLastName(final String val) {
		lastName = StringUtils.capitalize(val);
	}

	@Getter
	private String address;

	public void setAddress(final String val) {
		address = WordUtils.capitalizeFully(val);
	}
}
