/*
 *
 */
package org.ashtonestates.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class MasterBoardMember {

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
	@Column(name = "FIRSTNAME", nullable = false)
	@Getter
	private String firstName;

	public void setFirstName(final String val) {
		firstName = StringUtils.capitalize(val);
	}

	@NotEmpty
	@Column(name = "LASTNAME", nullable = false)
	@Getter
	private String lastName;

	public void setLastName(final String val) {
		lastName = StringUtils.capitalize(val);
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MEMBERROLE", nullable = true)
	@Getter
	@Setter
	private MemberRole memberRole;

	public MasterBoardMember(final String inFirstname, final String inLastname, final String inEmail) {
		firstName = inFirstname;
		lastName = inLastname;
		email = inEmail;
		memberRole = MemberRole.MEMBER;
	}

	public MasterBoardMember(final String inFirstname, final String inLastname, final String inEmail, final MemberRole inRole) {
		this(inFirstname, inLastname, inEmail);
		memberRole = MemberRole.MEMBER;
	}
}