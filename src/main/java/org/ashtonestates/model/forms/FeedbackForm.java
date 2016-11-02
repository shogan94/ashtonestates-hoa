/*
 *
 */
package org.ashtonestates.model.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FeedbackForm {
	@Getter
	@Setter
	private String feedback;

	@Getter
	@Setter
	private boolean masterboard;

	@Getter
	@Setter
	private boolean homeboard;

	@Getter
	@Setter
	private boolean townboard;

	@Getter
	@Setter
	private boolean president;

	@Getter
	@Setter
	private boolean secretary;

	@Getter
	@Setter
	private boolean treasurer;
}
