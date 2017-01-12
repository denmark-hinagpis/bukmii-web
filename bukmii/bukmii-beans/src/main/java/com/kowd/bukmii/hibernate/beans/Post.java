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

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author dchinagpis
 *
 */
@Entity
public class Post extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GenericGenerator(
			name = "sequence_post_id",
			strategy = "com.kowd.bukmii.hibernate.generator.PostIdGenerator"
	)
	@GeneratedValue(generator = "sequence_post_id")
	@Column(name = "post_id")
	private String m_postId;

	/***/
	@Column(columnDefinition = "ntext", nullable = true)
	private String m_message;

	/***/
	@OneToMany(mappedBy = "m_post")
	private List<Photo> m_photos;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "like_post",
			joinColumns = {
					@JoinColumn(name = "post_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			}
	)
	private List<User> m_likes;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_post",
			joinColumns = {
					@JoinColumn(name = "post_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			}
	)
	private List<User> m_users;

	/***/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "business_post",
			joinColumns = {
					@JoinColumn(name = "post_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "business_id", nullable = false, updatable = false)
			}
	)
	private List<Business> m_businesses;

	/***/
	public Post() {
	}

	/**
	 *
	 * @return String
	 */
	public String getPostId() {
		return m_postId;
	}

	/**
	 *
	 * @param postId String
	 */
	public void setPostId(final String postId) {
		this.m_postId = postId;
	}

	/**
	 *
	 * @return String
	 */
	public String getMessage() {
		return m_message;
	}

	/**
	 *
	 * @param message String
	 */
	public void setMessage(final String message) {
		this.m_message = message;
	}

	/**
	 *
	 * @return List<Photo>
	 */
	public List<Photo> getPhotos() {
		if (null == m_photos) {
			m_photos = new ArrayList<>();
		}
		return m_photos;
	}

	/**
	 *
	 * @param photos List<Photo>
	 */
	public void setPhotos(final List<Photo> photos) {
		this.m_photos = photos;
	}

	/**
	 *
	 * @return List<User>
	 */
	public List<User> getLikes() {
		if (null == m_likes) {
			m_likes = new ArrayList<>();
		}
		return m_likes;
	}

	/**
	 *
	 * @param likes List<User>
	 */
	public void setLikes(final List<User> likes) {
		this.m_likes = likes;
	}

	/**
	 *
	 * @return List<User>
	 */
	public List<User> getUsers() {
		if (null == m_users) {
			m_users = new ArrayList<>();
		}
		return m_users;
	}

	/**
	 *
	 * @param users List<User>
	 */
	public void setUsers(final List<User> users) {
		this.m_users = users;
	}

	/**
	 *
	 * @return List<Business>
	 */
	public List<Business> getBusinesses() {
		return m_businesses;
	}

	/**
	 *
	 * @param businesses List<Business>
	 */
	public void setBusinesses(final List<Business> businesses) {
		this.m_businesses = businesses;
	}

	@Override
	public final String toString() {
		return m_postId + ", " + m_message;
	}

}
