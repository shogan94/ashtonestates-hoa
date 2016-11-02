/*
 *
 */
package org.ashtonestates.model.forms;

import org.apache.commons.lang3.StringUtils;
import org.ashtonestates.model.MemberRole;

import lombok.Getter;
import lombok.Setter;

public class BoardMemberForm {
	@Getter
	@Setter
	private String id;

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
	@Setter
	private String email;

	@Getter
	@Setter
	private MemberRole memberRole;

}
