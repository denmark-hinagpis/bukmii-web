package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dchinagpis
 *
 */
@Entity
@Table(name = "reservation_histor")
public class ReservationHistory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "reservation_history_id")
	private long m_id;

	/***/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "reservation_id", nullable = false)
	})
	private Reservation m_item;

	/***/
	@Column(name = "prev_status")
	private char m_prevStatus;

	/***/
	public ReservationHistory() {
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
	 * @return Reservation
	 */
	public Reservation getItem() {
		return m_item;
	}

	/**
	 *
	 * @param item Reservation
	 */
	public void setItem(final Reservation item) {
		this.m_item = item;
	}

	/**
	 *
	 * @return char
	 */
	public char getPrevStatus() {
		return m_prevStatus;
	}

	/**
	 *
	 * @param prevStatus char
	 */
	public void setPrevStatus(final char prevStatus) {
		this.m_prevStatus = prevStatus;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_item.getId() + ", " + m_prevStatus;
	}

}
