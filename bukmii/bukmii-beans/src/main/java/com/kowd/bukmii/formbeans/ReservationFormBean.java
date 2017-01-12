package com.kowd.bukmii.formbeans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dchinagpis
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ReservationFormBean extends BaseFormBean implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	/***/
	@XmlElement(name = "id", required = true)
	private String m_id;

	/***/
	@XmlElement(name = "itemId", required = true)
	private String m_itemId;

	/***/
	@XmlElement(name = "userId", required = true)
	private String m_userId;

	/***/
	@XmlElement(name = "status", required = true)
	private String m_status;

	/**
	 * @param id String
	 * @param itemId String
	 * @param userId String
	 * @param status String
	 * @param createDate String
	 * @param updateDate String
	 */
	public ReservationFormBean(final String id,
							   final String itemId,
							   final String userId,
							   final String status,
							   final String createDate,
							   final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_itemId = itemId;
		this.m_userId = userId;
		this.m_status = status;
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
	public String getItemId() {
		return m_itemId;
	}

	/**
	 *
	 * @param itemId String
	 */
	public void setItemId(final String itemId) {
		this.m_itemId = itemId;
	}

	/**
	 *
	 * @return String
	 */
	public String getUserId() {
		return m_userId;
	}

	/**
	 *
	 * @param userId String
	 */
	public void setUserId(final String userId) {
		this.m_userId = userId;
	}

	/**
	 *
	 * @return String
	 */
	public String getStatus() {
		return m_status;
	}

	/**
	 *
	 * @param status String
	 */
	public void setStatus(final String status) {
		this.m_status = status;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_itemId + ", " + m_userId + ", " + m_status;
	}

}
