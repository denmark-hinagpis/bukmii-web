package com.kowd.bukmii.formbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dchinagpis
 *
 */

public class PhotoFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_id;

	/***/
	private String m_thumb;

	/***/
	private String m_medium;

	/***/
	private String m_original;

	/***/
	private List<String> m_likeUserIds;

	/***/
	public PhotoFormBean() {
		super(null, null);
		this.m_id = "-1";
		this.m_thumb = "thumb/missing.jpeg";
		this.m_medium = "medium/missing.jpeg";
		this.m_original = "original/missing.jpeg";
		this.m_likeUserIds = new ArrayList<>();
	}

	/**
	 * @param id String
	 * @param thumb String
	 * @param medium String
	 * @param original String
	 * @param likeUserIds List<String>
	 * @param createDate String
	 * @param updateDate String
	 */
	public PhotoFormBean(final String id,
						 final String thumb,
						 final String medium,
						 final String original,
						 final List<String> likeUserIds,
						 final String createDate,
						 final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_thumb = thumb;
		this.m_medium = medium;
		this.m_original = original;
		this.m_likeUserIds = likeUserIds;
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
	public String getThumb() {
		return m_thumb;
	}

	/**
	 *
	 * @param thumb String
	 */
	public void setThumb(final String thumb) {
		this.m_thumb = thumb;
	}

	/**
	 *
	 * @return String
	 */
	public String getMedium() {
		return m_medium;
	}

	/**
	 *
	 * @param medium String
	 */
	public void setMedium(final String medium) {
		this.m_medium = medium;
	}

	/**
	 *
	 * @return String
	 */
	public String getOriginal() {
		return m_original;
	}

	/**
	 *
	 * @param original String
	 */
	public void setOriginal(final String original) {
		this.m_original = original;
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
	 * @param likesUserId List<String>
	 */
	public void setLikeUserIds(final List<String> likesUserId) {
		this.m_likeUserIds = likesUserId;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_thumb + ", " + m_medium + ", " + m_original;
	}

}
