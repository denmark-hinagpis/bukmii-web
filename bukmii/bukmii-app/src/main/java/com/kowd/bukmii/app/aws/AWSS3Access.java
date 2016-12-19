package com.kowd.bukmii.app.aws;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kowd.bukmii.app.util.Crypt;

/**
 * @author dchinagpis
 *
 */
public final class AWSS3Access extends Properties {

	private static final long serialVersionUID = 1L;

	/***/
	private static final Logger LOGGER = LogManager.getLogger(AWSS3Access.class);

	/***/
	private static final String ACCESS_KEY = "aws.access.key";

	/***/
	private static final String SECRET_KEY = "aws.secret.key";

	/***/
	private static AWSS3Access properties;

	/***/
	private AWSS3Access() {
	}

	/**
	 *
	 * @return AWSS3Access
	 */
	public static AWSS3Access getInstance() {
		if (null == properties) {
			properties = new AWSS3Access();
			try {
				properties.load(AWSS3Access.class.getResourceAsStream("aws.properties"));
			} catch (final IOException e) {
				LOGGER.error("Failed to load aws properties.", e);
			}
		}
		return properties;
	}

	/**
	 *
	 * @return String
	 */
	public String getAccessKey() {
		if (null != properties) {
			return Crypt.decryptHexString(properties.getProperty(ACCESS_KEY));
		}
		return "";
	}

	/**
	 *
	 * @return String
	 */
	public String getSecretKey() {
		if (null != properties) {
			return Crypt.decryptHexString(properties.getProperty(SECRET_KEY));
		}
		return "";
	}

}
