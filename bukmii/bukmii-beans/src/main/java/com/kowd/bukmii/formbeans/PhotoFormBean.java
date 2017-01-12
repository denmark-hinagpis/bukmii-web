package com.kowd.bukmii.formbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class PhotoFormBean extends BaseFormBean implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	/***/
	@XmlElement(name = "id", required = true)
	private String m_id;

	/***/
	@XmlElement(name = "thumb", required = true)
	private String m_thumb;

	/***/
	@XmlElement(name = "medium", required = true)
	private String m_medium;

	/***/
	@XmlElement(name = "original", required = true)
	private String m_original;

	/***/
	@XmlElement(name = "likeUserIds", required = false)
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
