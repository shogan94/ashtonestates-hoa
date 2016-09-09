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

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", unique = true, nullable = false)
	private RoleType type = RoleType.USER;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public RoleType getType() {
		return type;
	}

	public void setType(final RoleType type) {
		this.type = type;
	}

	public Role() {

	}

	public Role(final RoleType role) {
		setType(role);
		setId(role.ordinal() + 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Role)) {
			return false;
		}
		final Role other = (Role) obj;
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ",  type=" + type + "]";
	}
}