package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author dhinagpis
 *
 */
@Entity
public class Business extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GenericGenerator(
			name = "sequence_business_id",
			strategy = "com.kowd.bukmii.hibernate.generator.BusinessIdGenerator"
	)
	@GeneratedValue(generator = "sequence_business_id")
	@Column(name = "business_id")
	private String m_id;

	/***/
	@ManyToOne(optional = false)
    @JoinColumn(name = "sub_category_id", nullable = false)
	private SubCategory m_subCategory;

	/***/
	@ManyToOne(optional = false)
    @JoinColumn(name = "location_id", nullable = false)
	private Location m_address;

	/***/
	@Column(name = "user_name")
	private String m_userName;

	/***/
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<BusinessPages> m_pages;

	/***/
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<BusinessContacts> m_contacts;

	/***/
	@Column(name = "name", nullable = false)
	private String m_name;

	/***/
	@Column(name = "business_hour")
	private String m_businessHours;

	/***/
	@Column(name = "subscription_type", nullable = false)
	private String m_subscriptionType;

	/***/
	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Photo m_image;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "business_admins",
			joinColumns = {
					@JoinColumn(name = "business_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			}
	)
	private List<User> m_admins;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "business_post",
			joinColumns = {
					@JoinColumn(name = "business_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "post_id", nullable = false, updatable = false)
			}
	)
	private List<Post> m_posts;

	/***/
	public Business() {
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
	public String getUserName() {
		return m_userName;
	}

	/**
	 *
	 * @param userName String
	 */
	public void setUserName(final String userName) {
		this.m_userName = userName;
	}

	/**
	 *
	 * @return SubCategory
	 */
	public SubCategory getSubCategory() {
		return m_subCategory;
	}

	/**
	 *
	 * @param subCategory SubCategory
	 */
	public void setSubCategory(final SubCategory subCategory) {
		this.m_subCategory = subCategory;
	}

	/**
	 *
	 * @return Location
	 */
	public Location getAddress() {
		return m_address;
	}

	/**
	 *
	 * @param address Location
	 */
	public void setAddress(final Location address) {
		this.m_address = address;
	}

	/**
	 *
	 * @return List<BusinessPages>
	 */
	public List<BusinessPages> getPages() {
		return m_pages;
	}

	/**
	 *
	 * @param pages List<BusinessPages>
	 */
	public void setPages(final List<BusinessPages> pages) {
		this.m_pages = pages;
	}

	/**
	 *
	 * @return List<BusinessContacts>
	 */
	public List<BusinessContacts> getContacts() {
		return m_contacts;
	}

	/**
	 *
	 * @param contacts List<BusinessContacts>
	 */
	public void setContacts(final List<BusinessContacts> contacts) {
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
	 * @return Photo
	 */
	public Photo getImage() {
		return m_image;
	}

	/**
	 *
	 * @param image Photo
	 */
	public void setImage(final Photo image) {
		this.m_image = image;
	}

	/**
	 *
	 * @return List<User>
	 */
	public List<User> getAdmins() {
		return m_admins;
	}

	/**
	 *
	 * @param admins List<User>
	 */
	public void setAdmins(final List<User> admins) {
		this.m_admins = admins;
	}

	/**
	 *
	 * @return List<Post>
	 */
	public List<Post> getPosts() {
		return m_posts;
	}

	/**
	 *
	 * @param posts List<Post>
	 */
	public void setPosts(final List<Post> posts) {
		this.m_posts = posts;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_userName + ", " + m_subCategory.getId() + ", " +
				m_address.getId() + ", " + m_name + ", " +
				m_businessHours + ", " + m_subscriptionType;
	}
}
