package com.kowd.bukmii.formbeans;

import java.io.Serializable;

/**
 *
 * @author dchinagpis
 *
 */
public class ReservationItemFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_id;

	/***/
	private String m_businessId;

	/***/
	private String m_name;

	/***/
	private String m_description;

	/**
	 * @param id String
	 * @param businessId String
	 * @param name String
	 * @param description String
	 * @param createDate String
	 * @param updateDate String
	 */
	public ReservationItemFormBean(final String id,
								   final String businessId,
								   final String name,
								   final String description,
								   final String createDate,
								   final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_businessId = businessId;
		this.m_name = name;
		this.m_description = description;
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
	public String getBusinessId() {
		return m_businessId;
	}

	/**
	 *
	 * @param businessId String
	 */
	public void setBusinessId(final String businessId) {
		this.m_businessId = businessId;
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
		return m_id + ", " + m_businessId + ", " + m_name + ", " + m_description;
	}

}
