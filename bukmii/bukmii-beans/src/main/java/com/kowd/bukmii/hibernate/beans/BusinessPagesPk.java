package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;

/**
 * @author dchinagpis
 *
 */
public class BusinessPagesPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private long m_id;

	/***/
	private Business m_business;

	/***/
	public BusinessPagesPk() {
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

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		int businessHash = 0;
		if (null != m_business) {
			businessHash = m_business.hashCode();
		}
		result = prime * result + businessHash;
		result = prime * result + (int) (m_id ^ (m_id >>> 32));
		return result;
	}

	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BusinessPagesPk other = (BusinessPagesPk) obj;
		if (m_business == null) {
			if (other.m_business != null) {
				return false;
			}
		} else if (!m_business.equals(other.m_business)) {
			return false;
		}
		if (m_id != other.m_id) {
			return false;
		}
		return true;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_business.getId();
	}

}
