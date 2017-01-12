package com.kowd.bukmii.formbeans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dchinagpis
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ResponseFormBean implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	/***/
	@XmlElement(name = "status", required = true)
	private int m_status;

	/***/
	@XmlElement(name = "message", required = false)
	private String m_message;

	/***/
	@XmlElement(name = "data", required = false)
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
