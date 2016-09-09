/*
 *
 */
package org.ashtonestates.user.model.forms;

import org.apache.commons.lang3.text.WordUtils;

import lombok.Getter;
import lombok.Setter;

public class EventForm {
	@Getter
	@Setter
	private String id;
	@Getter
	private String title;
	@Getter
	@Setter
	private String eventDate;
	@Getter
	@Setter
	private String description;

	public void setTitle(final String val) {
		title = WordUtils.capitalizeFully(val);
	}
}
