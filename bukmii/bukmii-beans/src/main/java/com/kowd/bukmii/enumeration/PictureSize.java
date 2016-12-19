package com.kowd.bukmii.enumeration;

/**
 *
 * @author dchinagpis
 *
 */
public enum PictureSize implements EnumInterface {

	/***/
	ORIGINAL("original"),
	/***/
	THUMB("thumb"),
	/***/
	MEDIUM("medium");

	/***/
	private String m_value;

	/**
	 * @param value String
	 */
	PictureSize(final String value) {
		m_value = value;
	}

	/**
	 *
	 * @param value String
	 * @return PicureSize
	 */
	public static PictureSize fromValue(final String value) {
		for (final PictureSize entityType : PictureSize.values()) {
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
