/*
 *
 */
package org.ashtonestates.model.forms;

import lombok.Getter;
import lombok.Setter;

public class ChangePwdForm {
	@Getter
	@Setter
	private Long userId;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String confirmPassword;
}
