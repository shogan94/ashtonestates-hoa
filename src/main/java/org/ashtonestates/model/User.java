/*
 *
 */
package org.ashtonestates.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_accounts")
@EntityListeners(DatabaseListener.class)
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private long id;

	@NotEmpty
	@Column(name = "EMAIL", unique = true, nullable = false)
	@Getter
	@Setter
	private String email;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	@Getter
	@Setter
	private String password;

	@NotEmpty
	@Column(name = "FIRSTNAME", nullable = false)
	@Getter
	private String firstName;

	@NotEmpty
	@Column(name = "LASTNAME", nullable = false)
	@Getter
	private String lastName;

	@NotEmpty
	@Column(name = "ADDRESS", nullable = false)
	@Getter
	private String address;

	@Column(name = "PHONE", nullable = true)
	@Setter
	@Getter
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATE", nullable = false)
	@Getter
	@Setter
	private State state = State.PENDING;

	@Column(name = "APPROVED_BY", nullable = true)
	@Getter
	private String approvedBy;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	@Getter
	@Setter
	private Role role;

	@Column(name = "CREATED", nullable = false)
	@Setter
	@Getter
	private String created;

	@Column(name = "APPROVED_ON", nullable = true)
	@Setter
	@Getter
	private String approvedOn;

	public User(final String inFirstname, final String inLastname, final String inPwd, final String inAddress, final String inEmail, final String inPhone, final State inState) {
		firstName = inFirstname;
		lastName = inLastname;
		password = inPwd;
		address = inAddress;
		email = inEmail;
		phone = inPhone;
		state = inState;
	}

	public User(final String inFirstname, final String inLastname, final String inPwd, final String inAddress, final String inEmail, final String inPhone, final State inState,
			final Role inRole) {
		this(inFirstname, inLastname, inPwd, inAddress, inEmail, inPhone, inState);
		role = inRole;
	}

	public void setFirstName(final String val) {
		firstName = StringUtils.capitalize(val);
	}

	public void setLastName(final String val) {
		lastName = StringUtils.capitalize(val);
	}

	public void setAddress(final String val) {
		address = WordUtils.capitalizeFully(val);
	}

	public void setApprovedBy(final String val) {
		approvedBy = StringUtils.capitalize(val);
	}
}