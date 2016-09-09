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

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "documents")
public class Documents implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "filename", nullable = false)
	private String name;

	@Column(name = "path", nullable = false)
	private String path;

	@Column(name = "size", nullable = false)
	private Long size;

	@Column(name = "uploadedDate", nullable = false)
	private String uploadedDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	private DocumentType documentType;

	public Documents() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long val) {
		id = val;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(final Long size) {
		this.size = size;
	}

	public String getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(final String uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(final DocumentType documentType) {
		this.documentType = documentType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((uploadedDate == null) ? 0 : uploadedDate.hashCode());
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
		final Documents other = (Documents) obj;
		if (documentType != other.documentType) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!path.equals(other.path)) {
			return false;
		}
		if (size == null) {
			if (other.size != null) {
				return false;
			}
		} else if (!size.equals(other.size)) {
			return false;
		}
		if (uploadedDate == null) {
			if (other.uploadedDate != null) {
				return false;
			}
		} else if (!uploadedDate.equals(other.uploadedDate)) {
			return false;
		}
		return true;
	}

}