package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;

/**
 * @author dchinagpis
 *
 */
public class ReservationHistoryPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private long m_id;

	/***/
	private ReservationItem m_item;

	/***/
	public ReservationHistoryPk() {
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
	 * @return ReservationItem
	 */
	public ReservationItem getItem() {
		return m_item;
	}

	/**
	 *
	 * @param item ReservationItem
	 */
	public void setItem(final ReservationItem item) {
		this.m_item = item;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (m_id ^ (m_id >>> 32));
		int itemHash = 0;
		if (null != m_item) {
			itemHash = m_item.hashCode();
		}
		result = prime * result + itemHash;
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
		final ReservationHistoryPk other = (ReservationHistoryPk) obj;
		if (m_id != other.m_id) {
			return false;
		}
		if (m_item == null) {
			if (other.m_item != null) {
				return false;
			}
		} else if (!m_item.equals(other.m_item)) {
			return false;
		}
		return true;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_item.getId();
	}

}
