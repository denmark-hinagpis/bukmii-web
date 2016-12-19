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
@Table(name = "business_contacts")
@IdClass(BusinessContactsPk.class)
public class BusinessContacts extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@Column(name = "business_contact_id")
	private long m_id;

	/***/
	@Id
	@Column(name = "business_id")
	private Business m_business;

	/***/
	@Column(name = "phone_number", nullable = false)
	private String m_phoneNumber;

	/***/
	public BusinessContacts() {
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
	public String getPhoneNumber() {
		return m_phoneNumber;
	}

	/**
	 *
	 * @param phoneNumber String
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.m_phoneNumber = phoneNumber;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_business.getId() + ", " + m_phoneNumber;
	}
}
