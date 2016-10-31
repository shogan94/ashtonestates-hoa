/*
 *
 */
package org.ashtonestates.model.forms;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.ashtonestates.model.Role;

import lombok.Getter;
import lombok.Setter;

public class ResidentInfoForm {
	@Getter
	@Setter
	private Long userId;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private Role role;

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
