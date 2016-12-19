package com.kowd.bukmii.formbeans;

import java.io.Serializable;

/**
 *
 * @author dhinagpis
 *
 */
public class SubCategoryFormBean extends BaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private String m_id;

	/***/
	private String m_categoryId;

	/***/
	private String m_name;

	/**
	 *
	 * @param id String
	 * @param categoryId String
	 * @param name String
	 * @param createDate String
	 * @param updateDate String
	 */
	public SubCategoryFormBean(final String id,
					   final String categoryId,
					   final String name,
					   final String createDate,
					   final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_categoryId = categoryId;
		this.m_name = name;
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
	public String getCategoryId() {
		return m_categoryId;
	}

	/**
	 *
	 * @param categoryId String
	 */
	public void setCategoryId(final String categoryId) {
		this.m_categoryId = categoryId;
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

	@Override
	public final String toString() {
		return m_id + ", " + m_categoryId + ", " + m_name;
	}
}
