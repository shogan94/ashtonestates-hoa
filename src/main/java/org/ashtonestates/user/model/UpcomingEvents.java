/*
 *
 */
package org.ashtonestates.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upcoming_events")
public class UpcomingEvents implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "eventDate", nullable = false)
	private String eventDate;

	@Column(name = "description", nullable = false)
	private String description;

	public UpcomingEvents() {
	}

	public UpcomingEvents(final String title, final String eventDate, final String description) {
		setTitle(title);
		setEventDate(eventDate);
		setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long val) {
		id = val;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UpcomingEvents other = (UpcomingEvents) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (eventDate == null) {
			if (other.eventDate != null) {
				return false;
			}
		} else if (!eventDate.equals(other.eventDate)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

}
