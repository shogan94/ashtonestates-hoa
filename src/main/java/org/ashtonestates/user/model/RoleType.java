package org.ashtonestates.user.model;

public enum RoleType {
	USER("USER"), ADMIN("ADMIN");

	String roleType;

	private RoleType(String val) {
		this.roleType = val;
	}

	public String getRoleType() {
		return roleType;
	}

}