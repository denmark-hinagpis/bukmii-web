package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author dchinagpis
 *
 */

@Entity
@Table(name = "reservation_item")
@IdClass(ReservationItemPk.class)
public class ReservationItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "reservation_item_id")
	private int m_id;

	/***/
	@Id
	@Column(name = "business_id")
	private Business m_business;

	/***/
	@Column(nullable = false)
	private String m_name;

	/***/
	@Column(nullable = false, columnDefinition = "ntext", length = 500)
	private String m_description;

	/***/
	public ReservationItem() {
	}

	/**
	 *
	 * @return int
	 */
	public int getId() {
		return m_id;
	}

	/**
	 *
	 * @param id int
	 */
	public void setId(final int id) {
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
	public String getName() {
		return m_name;
	}

	/**
	 *
	 * @param name String
	 */
	public void setName(final String name) {
		this.m_name = name;
	}

	/**
	 *
	 * @return String
	 */
	public String getDescription() {
		return m_description;
	}

	/**
	 *
	 * @param description String
	 */
	public void setDescription(final String description) {
		this.m_description = description;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_business.getId() + ", " + m_name + ", " + m_description;
	}

}
