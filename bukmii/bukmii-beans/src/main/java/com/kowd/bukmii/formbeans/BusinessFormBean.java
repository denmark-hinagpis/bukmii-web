package com.kowd.bukmii.formbeans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dhinagpis
 *
 */

public class BusinessFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_id;

	/***/
	private String m_subCategoryId;

	/***/
	private String m_locationId;

	/***/
	private List<String> m_pages;

	/***/
	private List<String> m_contacts;

	/***/
	private String m_name;

	/***/
	private String m_businessHours;

	/***/
	private String m_subscriptionType;

	/***/
	private PhotoFormBean m_image;

	/***/
	private List<String> m_userIds;

	/**
	 * @param id String
	 * @param subCategoryId String
	 * @param locationId String
	 * @param name String
	 * @param businessHours String
	 * @param subscriptionType String
	 * @param image PhotoFormBean
	 * @param createdDate String
	 * @param updatedDate String
	 * @param userIds List<String>
	 */
	public BusinessFormBean(final String id,
							final String subCategoryId,
							final String locationId,
							final String name,
							final String businessHours,
							final String subscriptionType,
							final PhotoFormBean image,
							final String createdDate,
							final String updatedDate,
							final List<String> userIds) {
		super(createdDate, updatedDate);
		this.m_id = id;
		this.m_subCategoryId = subCategoryId;
		this.m_locationId = locationId;
		this.m_name = name;
		this.m_businessHours = businessHours;
		this.m_subscriptionType = subscriptionType;
		this.m_image = image;
		this.m_userIds = userIds;
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
	public String getSubCategoryId() {
		return m_subCategoryId;
	}

	/**
	 *
	 * @param subCategoryId String
	 */
	public void setSubCategoryId(final String subCategoryId) {
		this.m_subCategoryId = subCategoryId;
	}

	/**
	 *
	 * @return String
	 */
	public String getLocationId() {
		return m_locationId;
	}

	/**
	 *
	 * @param locationId String
	 */
	public void setLocationId(final String locationId) {
		this.m_locationId = locationId;
	}

	/**
	 *
	 * @return String
	 */
	public List<String> getPages() {
		return m_pages;
	}

	/**
	 *
	 * @param pages List<String>
	 */
	public void setPages(final List<String> pages) {
		this.m_pages = pages;
	}

	/**
	 *
	 * @return List<String>
	 */
	public List<String> getContacts() {
		return m_contacts;
	}

	/**
	 *
	 * @param contacts List<String>
	 */
	public void setContacts(final List<String> contacts) {
		this.m_contacts = contacts;
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
	public String getBusinessHours() {
		return m_businessHours;
	}

	/**
	 *
	 * @param businessHours String
	 */
	public void setBusinessHours(final String businessHours) {
		this.m_businessHours = businessHours;
	}

	/**
	 *
	 * @return String
	 */
	public String getSubscriptionType() {
		return m_subscriptionType;
	}

	/**
	 *
	 * @param subscriptionType String
	 */
	public void setSubscriptionType(final String subscriptionType) {
		this.m_subscriptionType = subscriptionType;
	}

	/**
	 *
	 * @return PhotoFormBean
	 */
	public PhotoFormBean getImage() {
		return m_image;
	}

	/**
	 *
	 * @param image PhotoFormBean
	 */
	public void setImage(final PhotoFormBean image) {
		this.m_image = image;
	}

	/**
	 *
	 * @return List<String>
	 */
	public List<String> getUserIds() {
		return m_userIds;
	}

	/**
	 *
	 * @param userIds List<String>
	 */
	public void setUserIds(final List<String> userIds) {
		this.m_userIds = userIds;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_subCategoryId + ", " + m_locationId + ", " +
				m_name + ", " + m_businessHours + ", " + m_subscriptionType;
	}
}
