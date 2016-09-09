/*
 *
 */
package org.ashtonestates.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ROLE")
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class Role {

	@Id
	@Getter
	@Setter
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", unique = true, nullable = false)
	@Getter
	@Setter
	private RoleType type = RoleType.USER;

	public Role(final RoleType role) {
		setType(role);
		setId(role.ordinal() + 1);
	}
}