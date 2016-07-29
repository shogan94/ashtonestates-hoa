/*
 *
 */
package org.ashtonestates.user.model;

import java.util.Date;

public class AshtonDocument {
	private String name;
	private Date lastModified;
	private long length;
	private String file;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(final Date lastModified) {
		this.lastModified = lastModified;
	}

	public long getLength() {
		return length;
	}

	public void setLength(final long length) {
		this.length = length;
	}

	public String getFile() {
		return file;
	}

	public void setFile(final String file) {
		this.file = file;
	}

	public AshtonDocument() {

	}

	public AshtonDocument(final String n, final long d, final long l, final String f) {
		setName(n);
		setLastModified(new Date(d));
		setLength(l);
		setFile(f);
	}
}
