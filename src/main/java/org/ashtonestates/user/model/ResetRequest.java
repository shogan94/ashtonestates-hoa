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

@Entity
@Table(name = "reset_requests")
public class ResetRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "requestId", nullable = false)
	private String requestId;

	@OneToOne(optional = false)
	private User user;

	@Column(name = "expires", nullable = false)
	private String expires;

	public ResetRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long val) {
		id = val;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(final String requestId) {
		this.requestId = requestId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(final String expires) {
		this.expires = expires;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		final ResetRequest other = (ResetRequest) obj;
		if (requestId == null) {
			if (other.requestId != null) {
				return false;
			}
		} else if (!requestId.equals(other.requestId)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
}