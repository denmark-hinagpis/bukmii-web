package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author dchinagpis
 *
 */
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"reservation_item_id", "user_id"})
})
public class Reservation extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "reservation_id")
	private long m_id;

	/***/
	@Column(name = "reservation_item_id", nullable = false)
	private ReservationItem m_item;

	/***/
	@Column(name = "user_id", nullable = false)
	private User m_user;

	/***/
	private char m_status;

	/***/
	@OneToMany(mappedBy = "item")
	private List<ReservationHistory> m_history;

	/***/
	public Reservation() {
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

	/**
	 *
	 * @return User
	 */
	public User getUser() {
		return m_user;
	}

	/**
	 *
	 * @param user User
	 */
	public void setUser(final User user) {
		this.m_user = user;
	}

	/**
	 *
	 * @return char
	 */
	public char getStatus() {
		return m_status;
	}

	/**
	 *
	 * @param status char
	 */
	public void setStatus(final char status) {
		this.m_status = status;
	}

	/**
	 *
	 * @return List<ReservationHistory>
	 */
	public List<ReservationHistory> getHistory() {
		if (null == m_history) {
			m_history = new ArrayList<>();
		}
		return m_history;
	}

	/**
	 *
	 * @param history List<ReservationHistory>
	 */
	public void setHistory(final List<ReservationHistory> history) {
		this.m_history = history;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_item.getId() + ", " + m_user.getId() + ", " + m_status;
	}

}
