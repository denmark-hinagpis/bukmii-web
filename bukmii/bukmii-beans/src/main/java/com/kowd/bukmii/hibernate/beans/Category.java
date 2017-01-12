package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author dhinagpis
 *
 */
@Entity
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private long m_id;

	/***/
	@Column(nullable = false, unique = true)
	private String m_name;

	/***/
	@Column(nullable = false, length = 6)
	private String m_color;

	/***/
    @OneToMany(mappedBy = "m_category", fetch = FetchType.LAZY)
	private List<SubCategory> m_subCategory;

	/***/
	public Category() {

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
	 * @return List<SubCategory>
	 */
	public List<SubCategory> getSubCategory() {
		return m_subCategory;
	}

	/**
	 *
	 * @param subCategory List<SubCategory>
	 */
	public void setSubCategory(final List<SubCategory> subCategory) {
		this.m_subCategory = subCategory;
	}

	/**
	 *
	 * @return String
	 */
	public String getColor() {
		return m_color;
	}

	/**
	 *
	 * @param color String
	 */
	public void setColor(final String color) {
		this.m_color = color;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_name + ", " + m_color;
	}
}
