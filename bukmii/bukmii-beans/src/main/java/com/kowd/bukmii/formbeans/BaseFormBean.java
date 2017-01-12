package com.kowd.bukmii.formbeans;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author dchinagpis
 *
 */
public class BaseFormBean {

	/***/
	@XmlElement(name = "createDate", required = false)
	private String m_createDate;

	/***/
	@XmlElement(name = "updateDate", required = false)
	private String m_updateDate;

	/**
	 * @param createDate String
	 * @param updateDate String
	 */
	protected BaseFormBean(final String createDate,
					       final String updateDate) {
		this.m_createDate = createDate;
		this.m_updateDate = updateDate;
	}

	/**
	 *
	 * @return String
	 */
	public String getCreateDate() {
		return m_createDate;
	}

	/**
	 *
	 * @param createDate String
	 */
	public void setCreateDate(final String createDate) {
		this.m_createDate = createDate;
	}

	/**
	 *
	 * @return String
	 */
	public String getUpdateDate() {
		return m_updateDate;
	}

	/**
	 *
	 * @param updateDate String
	 */
	public void setUpdateDate(final String updateDate) {
		this.m_updateDate = updateDate;
	}

	/***/
	@Override
	public String toString() {
		return m_createDate + ", " + m_updateDate;
	}
}
