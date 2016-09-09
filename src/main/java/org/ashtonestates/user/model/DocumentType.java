package org.ashtonestates.user.model;

public enum DocumentType {
	PUBLIC_HOMES("PUBLIC_HOMES"),
	PUBLIC_TOWNHOME("PUBLIC_TOWNHOME"),
	RESIDENT_HOMES("RESIDENT_HOMES"),
	RESIDENT_TOWNHOME("RESIDENT_TOWNHOME");

	String docType;

	private DocumentType(final String val) {
		docType = val;
	}

	public String getDocType() {
		return docType;
	}

}