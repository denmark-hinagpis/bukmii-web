package com.kowd.bukmii.ui.servlet.common;

import java.util.Properties;

import org.json.JSONObject;

/**
 * @author dchinagpis
 *
 */
public final class Session {

	/***/
	private final Properties m_props;

	/**
	 * @param props Properties
	 */
	public Session(final Properties props) {
		m_props = props;
	}

	/**
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public String getAttributeAsString(final String key, final String defaultVal) {
		return m_props.getProperty(key, defaultVal);
	}

	/**
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public int getAttributeAsInt(final String key, final int defaultVal) {
		return Integer.parseInt(m_props.getProperty(key, "0"));
	}

	/**
	 * @param key String
	 * @return JSONObject
	 */
	public JSONObject getAttributeAsInt(final String key) {
		if (null != m_props.get(key)) {
			return new JSONObject(m_props.getProperty(key));
		}
		return null;
	}

	/**
	 * @param key String
	 * @return Object
	 */
	public Object get(final String key) {
		return m_props.get(key);
	}

	/**
	 * @param key String
	 * @param value Object
	 */
	public void put(final String key, final Object value) {
		m_props.put(key, value);
	}

	/**
	 * @return Properties
	 */
	Properties get() {
		return m_props;
	}

}
