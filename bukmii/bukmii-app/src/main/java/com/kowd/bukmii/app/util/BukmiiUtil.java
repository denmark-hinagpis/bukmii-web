package com.kowd.bukmii.app.util;

/**
 * @author dchinagpis
 *
 */
public final class BukmiiUtil {

	/***/
	private BukmiiUtil() {
	}

	/**
	 *
	 * @param value String
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(final String value) {
		if (null == value) {
			return true;
		}
		if (value.isEmpty()) {
			return true;
		}
		return false;
	}

}
