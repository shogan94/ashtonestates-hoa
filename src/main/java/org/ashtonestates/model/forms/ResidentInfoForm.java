/*
 *
 */
package org.ashtonestates.model.forms;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

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
	private String firstName;
	@Getter
	private String lastName;
	@Getter
	private String address;

	public void setFirstName(final String val) {
		firstName = StringUtils.capitalize(val);
	}

	public void setLastName(final String val) {
		lastName = StringUtils.capitalize(val);
	}

	public void setAddress(final String val) {
		address = WordUtils.capitalizeFully(val);
	}
}
