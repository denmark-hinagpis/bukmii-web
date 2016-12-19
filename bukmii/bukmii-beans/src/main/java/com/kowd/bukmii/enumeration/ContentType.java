package com.kowd.bukmii.enumeration;

/**
 *
 * @author dchinagpis
 *
 */
public enum ContentType implements EnumInterface {

	/***/
	JSON("application/json"),
	/***/
	XML("text/xml"),
	/***/
	HTML("text/html");

	/***/
	private String m_value;

	/**
	 * @param value - String equivalent ContentType Annotation
	 */
	ContentType(final String value) {
		m_value = value;
	}

	/**
	 *
	 * @param value - String equivalent ContentType Annotation
	 * @return ContentType
	 */
	public static ContentType fromValue(final String value) {
		for (final ContentType entityType : ContentType.values()) {
			if (value.equals(entityType.getValue())) {
				return entityType;
			}
		}
		return null;
	}

	@Override
	public String getValue() {
		return m_value;
	}

}
