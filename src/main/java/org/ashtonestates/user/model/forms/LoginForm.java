/*
 *
 */
package org.ashtonestates.user.model.forms;

import lombok.Getter;
import lombok.Setter;

public class LoginForm {
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String password;
}
