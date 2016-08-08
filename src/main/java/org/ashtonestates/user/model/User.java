/*
 *
 */
package org.ashtonestates.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user_accounts")
@EntityListeners(DatabaseListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotEmpty
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	@NotEmpty
	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATE", nullable = false)
	private State state = State.PENDING;

	@Column(name = "APPROVED_BY")
	private String approvedBy;

	@ManyToOne
	private Role role;

	// @ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	// private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(final String inFirstname, final String inLastname, final String inPwd, final String inAddress, final String inEmail, final State inState) {
		firstName = inFirstname;
		lastName = inLastname;
		password = inPwd;
		address = inAddress;
		email = inEmail;
		state = inState;
	}

	public int getId() {
		return id;
	}

	public void setId(final int val) {
		id = val;
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
		password = val;
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

	public State getState() {
		return state;
	}

	public void setState(final State val) {
		state = val;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role val) {
		role = val;
	}

	// public Set<Role> getRoles() {
	// return roles;
	// }
	//
	// public void setRoles(final Set<Role> obj) {
	// roles = obj;
	// }

	public String getAddress() {
		return address;
	}

	public void setAddress(final String val) {
		address = val;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(final String val) {
		approvedBy = val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		if (!(obj instanceof User)) {
			return false;
		}
		final User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", state=" + state + ", role=" + role
				+ "]";
	}

	public boolean isTownhouseUser() {
		return false;
	}

}