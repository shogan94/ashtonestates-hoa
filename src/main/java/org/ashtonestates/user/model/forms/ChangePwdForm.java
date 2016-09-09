/*
 *
 */
package org.ashtonestates.user.model.forms;

public class ChangePwdForm {
	private Long userId;
	private String password;
	private String confirmPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long val) {
		userId = val;
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
}
