package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author dhinagpis
 *
 */

@Entity
@Table(
		uniqueConstraints = { @UniqueConstraint(columnNames = {"email"})}
)
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GenericGenerator(
			name = "sequence_user_id",
			strategy = "com.kowd.bukmii.hibernate.generator.UserIdGenerator"
	)
	@GeneratedValue(generator = "sequence_user_id")
	@Column(name = "user_id")
	private String m_id;

	/***/
	@Column(name = "user_name")
	private String m_userName;

	/***/
	@Column(nullable = false)
	private String m_email;

	/***/
	@Column(name = "first_name", nullable = false)
	private String m_firstName;

	/***/
	@Column(name = "last_name", nullable = false)
	private String m_lastName;

	/***/
	@Column(name = "phone_number", length = 16)
	private String m_phoneNumber;

	/***/
	private String m_passcode;

	/***/
	private String m_password;

	/***/
	@Column(columnDefinition = "ntext", length = 500)
	private String m_about;

	/***/
	@OneToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	private Photo m_image;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_post",
			joinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "post_id", nullable = false, updatable = false)
			}
	)
	private List<Post> m_posts;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "business_admins",
			joinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "business_id", nullable = false, updatable = false)
			}
	)
	private List<Business> m_businesses;

	/***/
	public User() {
	}

	/**
	 * @return String
	 */
	public String getId() {
		return m_id;
	}

	/**
	 * @param id String
	 */
	public void setId(final String id) {
		m_id = id;
	}

	/**
	 * @return String
	 */
	public String getEmail() {
		return m_email;
	}

	/**
	 *
	 * @param email String
	 */
	public void setEmail(final String email) {
		m_email = email;
	}

	/**
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
		m_userName = userName;
	}

	/**
	 * @return String
	 */
	public String getFirstName() {
		return m_firstName;
	}

	/**
	 *
	 * @param firstName String
	 */
	public void setFirstName(final String firstName) {
		m_firstName = firstName;
	}

	/**
	 * @return String
	 */
	public String getLastName() {
		return m_lastName;
	}

	/**
	 *
	 * @param lastName String
	 */
	public void setLastName(final String lastName) {
		m_lastName = lastName;
	}

	/**
	 * @return String
	 */
	public String getPhoneNumber() {
		return m_phoneNumber;
	}

	/**
	 *
	 * @param phoneNumber String
	 */
	public void setPhoneNumber(final String phoneNumber) {
		m_phoneNumber = phoneNumber;
	}

	/**
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
		m_image = image;
	}

	/**
	 * @return String
	 */
	public String getPasscode() {
		return m_passcode;
	}

	/**
	 *
	 * @param passcode String
	 */
	public void setPasscode(final String passcode) {
		m_passcode = passcode;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return m_password;
	}

	/**
	 *
	 * @param password String
	 */
	public void setPassword(final String password) {
		m_password = password;
	}

	/**
	 * @return String
	 */
	public String getAbout() {
		return m_about;
	}

	/**
	 *
	 * @param about String
	 */
	public void setAbout(final String about) {
		m_about = about;
	}

	/**
	 * @return List<String>
	 */
	public List<Post> getPosts() {
		if (null == m_posts) {
			m_posts = new ArrayList<>();
		}
		return m_posts;
	}

	/**
	 *
	 * @param posts List<Post>
	 */
	public void setPosts(final List<Post> posts) {
		m_posts = posts;
	}

	/**
	 * @return List<String>
	 */
	public List<Business> getBusinesses() {
		return m_businesses;
	}

	/**
	 *
	 * @param businesses List<Business>
	 */
	public void setBusinesses(final List<Business> businesses) {
		m_businesses = businesses;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_email + ", " + m_userName + ", " + m_firstName + ", " + m_lastName;
	}

}
