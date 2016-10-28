/*
 *
 */
package org.ashtonestates.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "documents")
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
public class Documents implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;

	@Column(name = "filename", nullable = false)
	@Getter
	@Setter
	private String name;

	@Column(name = "path", nullable = false)
	@Getter
	@Setter
	private String path;

	@Column(name = "size", nullable = false)
	@Getter
	@Setter
	private Long size;

	@Column(name = "uploadedDate", nullable = false)
	@Getter
	@Setter
	private String uploadedDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	@Getter
	@Setter
	private DocumentType documentType;

}