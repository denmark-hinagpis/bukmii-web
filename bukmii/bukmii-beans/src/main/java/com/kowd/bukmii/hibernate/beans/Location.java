package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author dhinagpis
 *
 */
@Entity
public class Location extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private long m_id;

	/***/
	@Column(nullable = false)
	private long m_longitude;

	/***/
	@Column(nullable = false)
	private long m_latitude;

	/***/
	@Column(name = "address_name", nullable = false)
	private String m_addressName;

	/***/
	@Column(nullable = false)
	private String m_city;

	/***/
	@Column(nullable = false)
	private String m_country;

	/***/
	@Column(name = "zip_code", nullable = false)
	private String m_zipCode;

	/***/
    @OneToMany(mappedBy = "m_address", fetch = FetchType.LAZY)
	private List<Business> m_businesses;

	/***/
	public Location() {
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
	 * @return long
	 */
	public long getLongitude() {
		return m_longitude;
	}

	/**
	 *
	 * @param longitude long
	 */
	public void setLongitude(final long longitude) {
		this.m_longitude = longitude;
	}

	/**
	 *
	 * @return long
	 */
	public long getLatitude() {
		return m_latitude;
	}

	/**
	 *
	 * @param latitude long
	 */
	public void setLatitude(final long latitude) {
		this.m_latitude = latitude;
	}

	/**
	 *
	 * @return String
	 */
	public String getAddressName() {
		return m_addressName;
	}

	/**
	 *
	 * @param addressName String
	 */
	public void setAddressName(final String addressName) {
		this.m_addressName = addressName;
	}

	/**
	 *
	 * @return String
	 */
	public String getCity() {
		return m_city;
	}

	/**
	 *
	 * @param city String
	 */
	public void setCity(final String city) {
		this.m_city = city;
	}

	/**
	 *
	 * @return String
	 */
	public String getCountry() {
		return m_country;
	}

	/**
	 *
	 * @param country String
	 */
	public void setCountry(final String country) {
		this.m_country = country;
	}

	/**
	 *
	 * @return String
	 */
	public String getZipCode() {
		return m_zipCode;
	}

	/**
	 *
	 * @param zipCode String
	 */
	public void setZipCode(final String zipCode) {
		this.m_zipCode = zipCode;
	}

	/**
	 *
	 * @return List<Business>
	 */
	public List<Business> getBusinesses() {
		return m_businesses;
	}

	/**
	 *
	 * @param businesses List<Business>
	 */
	public void setBusinesses(final List<Business> businesses) {
		this.m_businesses = businesses;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_longitude + ", " + m_latitude + ", " +
				m_addressName + ", " + m_city + ", " +
				m_country + ", " + m_zipCode;
	}
}
