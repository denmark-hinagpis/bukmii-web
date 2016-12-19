package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author dhinagpis
 *
 */
@Entity
@Table(name = "business_pages")
@IdClass(BusinessPagesPk.class)
public class BusinessPages extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@Column(name = "business_page_id")
	private long m_id;

	/***/
	@Id
	@Column(name = "business_id")
	private Business m_business;

	/***/
	@Column(nullable = false)
	private String m_url;

	/***/
	public BusinessPages() {
	}

	/**
	 *
	 * @return long
	 */
	public long getId() {
		return m_id;
	}

	/**
	 *
	 * @param id long
	 */
	public void setId(final long id) {
		this.m_id = id;
	}

	/**
	 *
	 * @return Business
	 */
	public Business getBusiness() {
		return m_business;
	}

	/**
	 *
	 * @param business Business
	 */
	public void setBusiness(final Business business) {
		this.m_business = business;
	}

	/**
	 *
	 * @return String
	 */
	public String getUrl() {
		return m_url;
	}

	/**
	 *
	 * @param url String
	 */
	public void setUrl(final String url) {
		this.m_url = url;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_business.getId() + ", " + m_url;
	}
}
