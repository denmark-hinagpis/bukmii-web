package com.kowd.bukmii.hibernate.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author dchinagpis
 *
 */
@MappedSuperclass
public class BaseEntity {

	/***/
	@Column(name = "create_date", updatable = false)
	private Date m_createDate;

	/***/
	@Column(name = "update_date", updatable = true)
	private Date m_updateDate;

	/***/
	protected BaseEntity() {
		m_createDate = new Date();
		m_updateDate = new Date();
	}

	/**
	 *
	 * @return Date
	 */
	public Date getCreateDate() {
		return m_createDate;
	}

	/**
	 *
	 * @return Date
	 */
	public Date getUpdateDate() {
		return m_updateDate;
	}

	/**
	 *
	 * @param updateDate Date
	 */
	public void setUpdateDate(final Date updateDate) {
		this.m_updateDate = updateDate;
	}

	/**
	 *
	 * @param createDate Date
	 */
	public void setCreateDate(final Date createDate) {
		this.m_createDate = createDate;
	}
}
