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

import org.apache.commons.lang3.text.WordUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "upcoming_events")
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class UpcomingEvents implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;

	@Column(name = "title", nullable = false)
	@Getter
	private String title;

	@Column(name = "eventDate", nullable = false)
	@Getter
	@Setter
	private String eventDate;

	@Column(name = "description", nullable = false)
	@Getter
	@Setter
	private String description;

	public UpcomingEvents(final String title, final String eventDate, final String description) {
		setTitle(title);
		setEventDate(eventDate);
		setDescription(description);
	}

	public void setTitle(final String val) {
		title = WordUtils.capitalizeFully(val);
	}
}
