package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

import com.kowd.bukmii.enumeration.PictureSize;

/**
 *
 * @author dchinagpis
 *
 */
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"file_name", "file_type"})
})
public class Photo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "photo_id")
	private long m_id;

	/***/
	@Column(name = "file_name")
	private String m_fileName;

	/***/
	@Column(name = "file_type", nullable = false)
	private String m_fileType;

	/***/
    @ManyToOne(optional = true)
    @JoinColumn(name = "post_id", nullable = true)
	private Post m_post;

	/***/
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	@JoinTable(
			name = "like_photo",
			joinColumns = {
					@JoinColumn(name = "photo_id", nullable = false, updatable = false)
			},
			inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false)
			}
	)
	private List<User> m_likes;

	/***/
	public Photo() {
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
	 * @return String
	 */
	public String getFileName() {
		return m_fileName;
	}

	/**
	 *
	 * @param fileName String
	 */
	public void setFileName(final String fileName) {
		this.m_fileName = fileName;
	}

	/**
	 *
	 * @return String
	 */
	public String getFileType() {
		return m_fileType;
	}

	/**
	 *
	 * @param fileType String
	 */
	public void setFileType(final String fileType) {
		this.m_fileType = fileType;
	}

	/**
	 *
	 * @return Post
	 */
	public Post getPost() {
		return m_post;
	}

	/**
	 *
	 * @param post Post
	 */
	public void setPost(final Post post) {
		this.m_post = post;
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
	 * @param size PictureSize
	 * @return String
	 */
	public String getImagePath(final PictureSize size) {
		return size.getValue() + "/" + toString();
	}

	@Override
	public final String toString() {
		return m_fileName + "." + m_fileType;
	}

}
