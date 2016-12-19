package com.kowd.bukmii.ui.servlet.common;

import java.util.Properties;

import org.json.JSONObject;

/**
 * @author dchinagpis
 *
 */
public final class Request {

	/***/
	private final Properties m_attr;

	/***/
	private final Properties m_param;

	/***/
	private final Properties m_newAttr = new Properties();

	/**
	 * @param attr Properties
	 * @param param Properties
	 */
	public Request(final Properties attr, final Properties param) {
		m_attr = attr;
		m_param = param;
	}

	/**
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public String getAttributeAsString(final String key, final String defaultVal) {
		return m_attr.getProperty(key, defaultVal);
	}

	/**
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public int getAttributeAsInt(final String key, final int defaultVal) {
		return Integer.parseInt(m_attr.getProperty(key, "-1"));
	}

	/**
	 * @param key String
	 * @return JSONObject
	 */
	public JSONObject getAttributeAsInt(final String key) {
		if (null != m_attr.get(key)) {
			return new JSONObject(m_attr.getProperty(key));
		}
		return null;
	}

	/**
	 * @param key String
	 * @return Object
	 */
	public Object get(final String key) {
		return m_attr.get(key);
	}

	/**
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public String getParameterAsString(final String key, final String defaultVal) {
		return m_param.getProperty(key, defaultVal);
	}

	/**
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public int getParameterAsInt(final String key, final int defaultVal) {
		return Integer.parseInt(m_param.getProperty(key, "-1"));
	}

	/**
	 * @param key String
	 * @param value Object
	 */
	public void put(final String key, final Object value) {
		m_newAttr.put(key, value);
	}

	/**
	 * @return Properties
	 */
	Properties get() {
		return m_newAttr;
	}

}
