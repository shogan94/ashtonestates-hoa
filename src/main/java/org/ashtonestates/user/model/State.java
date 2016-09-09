package org.ashtonestates.user.model;

public enum State {

	APPROVED("Approved"),
	INACTIVE("Inactive"),
	PENDING("Pending");

	private String state;

	private State(final String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return state;
	}

	public String getName() {
		return this.name();
	}

}