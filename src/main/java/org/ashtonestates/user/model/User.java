/*
 *
 */
package org.ashtonestates.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

@Entity
@Table(name = "user_accounts")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "firstname", length = 100, nullable = false)
	private String firstName;

	@Column(name = "lastname", length = 100, nullable = false)
	private String lastName;

	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "streetAddress", length = 100, nullable = false)
	private String streetAddress;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private AshtonStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20, nullable = false)
	private Role role;

	@Column(name = "approvedBy", length = 200)
	private String approvedBy;

	public User() {
	}

	public User(final String inFirstName, final String inLastName, final String inPassword, final String inStreet, final String inEmail, final Role inRole,
			final AshtonStatus inStatus) {
		setFirstName(inFirstName);
		setLastName(inLastName);
		setPassword(inPassword);
		setStreetAddress(inStreet);
		setEmail(inEmail);
		setRole(inRole);
		setStatus(inStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long val) {
		id = val;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String val) {
		firstName = val;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String val) {
		lastName = val;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String val) {
		email = val;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String val) {
		password = DigestUtils.md5DigestAsHex(val.getBytes());
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(final String val) {
		streetAddress = val;
	}

	public AshtonStatus getStatus() {
		return status;
	}

	public void setStatus(final AshtonStatus status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(final String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public boolean isAdmin() {
		return role == Role.ROLE_ADMIN;
	}

	public boolean isTownhouse() {
		return StringUtils.containsIgnoreCase(streetAddress, "ashton place") || StringUtils.containsIgnoreCase(streetAddress, "ashton pl")
				|| StringUtils.containsIgnoreCase(streetAddress, "ashton p") || StringUtils.containsIgnoreCase(streetAddress, "ashtonp");
	}

	@Override
	public String toString() {
		return String.format("AshtonResident [id=%s, firstName=%s, lastName=%s, email=%s, password=%s, streetAddress=%s, status=%s, role=%s]", id, firstName, lastName, email,
				password, streetAddress, status, getRole());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.toLowerCase().hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.toLowerCase().hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.toLowerCase().hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.toLowerCase().hashCode());
		result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
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
		final User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equalsIgnoreCase(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equalsIgnoreCase(other.firstName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equalsIgnoreCase(other.lastName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (streetAddress == null) {
			if (other.streetAddress != null) {
				return false;
			}
		} else if (!streetAddress.equalsIgnoreCase(other.streetAddress)) {
			return false;
		}
		if (getRole() == null) {
			if (other.getRole() != null) {
				return false;
			}
		} else if (!getRole().equals(other.getRole())) {
			return false;
		}

		return true;
	}

}
