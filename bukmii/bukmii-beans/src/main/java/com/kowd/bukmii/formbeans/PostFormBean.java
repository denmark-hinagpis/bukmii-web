package com.kowd.bukmii.formbeans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dchinagpis
 *
 */
public class PostFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_postId;

	/***/
	private String m_message;

	/***/
	private List<PhotoFormBean> m_photos;

	/***/
	private List<String> m_likeUserIds;

	/**
	 * @param postId String
	 * @param message String
	 * @param photos List<PhotoFormBean>
	 * @param likeUserIds List<String>
	 * @param createDate String
	 * @param updateDate String
	 */
	public PostFormBean(final String postId,
						final String message,
						final List<PhotoFormBean> photos,
						final List<String> likeUserIds,
						final String createDate,
						final String updateDate) {
		super(createDate, updateDate);
		this.m_postId = postId;
		this.m_message = message;
		this.m_photos = photos;
		this.m_likeUserIds = likeUserIds;
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
	 * @return List<PhotoFormBean>
	 */
	public List<PhotoFormBean> getPhotos() {
		return m_photos;
	}

	/**
	 *
	 * @param photos List<PhotoFormBean>
	 */
	public void setPhotos(final List<PhotoFormBean> photos) {
		this.m_photos = photos;
	}

	/**
	 *
	 * @return List<String>
	 */
	public List<String> getLikeUserIds() {
		return m_likeUserIds;
	}

	/**
	 *
	 * @param likeUserIds List<String>
	 */
	public void setLikeUserIds(final List<String> likeUserIds) {
		this.m_likeUserIds = likeUserIds;
	}

	@Override
	public final String toString() {
		return m_postId + ", " + m_message;
	}

}
