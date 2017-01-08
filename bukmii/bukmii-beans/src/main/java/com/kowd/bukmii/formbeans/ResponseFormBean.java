package com.kowd.bukmii.formbeans;

import java.io.Serializable;

/**
 *
 * @author dchinagpis
 *
 */
public class ResponseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private int m_status;

	/***/
	private String m_message;

	/***/
	private Serializable m_data;

	/**
	 * @param status int
	 * @param message String
	 * @param data Serializable
	 */
	public ResponseFormBean(final int status, final String message, final Serializable data) {
		this.m_status = status;
		this.m_message = message;
		this.m_data = data;
	}

	/**
	 *
	 * @param status int
	 */
	public void setStatus(final int status) {
		this.m_status = status;
	}

	/**
	 *
	 * @param message String
	 */
	public void setMessage(final String message) {
		this.m_message = message;
	}

	/**
	 *
	 * @return int
	 */
	public int getStatus() {
		return m_status;
	}

	/**
	 *
	 * @return String
	 */
	public String getMessage() {
		return m_message;
	}

	/**
	 *
	 * @return Serializable
	 */
	public Serializable getData() {
		return m_data;
	}

	/**
	 *
	 * @param data Serializable
	 */
	public void setData(final Serializable data) {
		this.m_data = data;
	}

	@Override
	public final String toString() {
		return m_status + ", " + m_message + ", " + m_data;
	}
}
