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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reset_requests")
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class ResetRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;

	@Column(name = "requestId", nullable = false)
	@Getter
	@Setter
	private String requestId;

	@OneToOne(optional = false)
	@Getter
	@Setter
	private User user;

	@Column(name = "expires", nullable = false)
	@Getter
	@Setter
	private String expires;
}