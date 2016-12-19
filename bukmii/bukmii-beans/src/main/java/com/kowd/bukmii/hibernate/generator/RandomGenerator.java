package com.kowd.bukmii.hibernate.generator;

import java.util.UUID;

/**
 *
 * @author dchinagpis
 *
 */
public final class RandomGenerator {

	/***/
	private RandomGenerator() {
	}

	/**
	 *
	 * @return String
	 */
	public static String getRandString() {
		return UUID.randomUUID().toString();
	}

	/**
	 *
	 * @return String
	 */
	public static String rand12Char() {
		final String randVal = getRandString();
		return randVal.substring(randVal.lastIndexOf("-") + 1, randVal.length());
	}

	/**
	 *
	 * @return String
	 */
	public static String rand8Char() {
		final String randVal = getRandString();
		return randVal.substring(0, 7);
	}

}
