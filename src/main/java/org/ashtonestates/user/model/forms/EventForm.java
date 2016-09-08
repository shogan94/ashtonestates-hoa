/*
 *
 */
package org.ashtonestates.user.model.forms;

public class EventForm {
	private String id;
	private String title;
	private String eventDate;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(final String eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}
}
