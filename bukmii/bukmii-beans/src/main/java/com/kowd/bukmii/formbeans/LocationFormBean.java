package com.kowd.bukmii.formbeans;

import java.io.Serializable;

/**
 *
 * @author dhinagpis
 *
 */

public class LocationFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_id;

	/***/
	private String m_longitude;

	/***/
	private String m_latitude;

	/***/
	private String m_addressName;

	/***/
	private String m_city;

	/***/
	private String m_country;

	/***/
	private String m_zipCode;

	/**
	 * @param id String
	 * @param longitude String
	 * @param latitude String
	 * @param addressName String
	 * @param city String
	 * @param country String
	 * @param zipCode String
	 * @param createDate String
	 * @param updateDate String
	 */
	public LocationFormBean(final String id,
							final String longitude,
							final String latitude,
							final String addressName,
							final String city,
							final String country,
							final String zipCode,
							final String createDate,
							final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_longitude = longitude;
		this.m_latitude = latitude;
		this.m_addressName = addressName;
		this.m_city = city;
		this.m_country = country;
		this.m_zipCode = zipCode;
	}

	/**
	 *
	 * @return String
	 */
	public String getId() {
		return m_id;
	}

	/**
	 *
	 * @param id String
	 */
	public void setId(final String id) {
		this.m_id = id;
	}

	/**
	 *
	 * @return String
	 */
	public String getLongitude() {
		return m_longitude;
	}

	/**
	 *
	 * @param longitude String
	 */
	public void setLongitude(final String longitude) {
		this.m_longitude = longitude;
	}

	/**
	 *
	 * @return String
	 */
	public String getLatitude() {
		return m_latitude;
	}

	/**
	 *
	 * @param latitude String
	 */
	public void setLatitude(final String latitude) {
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

	@Override
	public final String toString() {
		return m_id + ", " + m_longitude + ", " + m_latitude + ", " + m_addressName + ", " +
				m_city + ", " + m_country + ", " + m_zipCode;
	}
}
