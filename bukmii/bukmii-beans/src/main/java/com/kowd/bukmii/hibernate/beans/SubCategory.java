package com.kowd.bukmii.hibernate.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author dhinagpis
 *
 */
@Entity
@Table(
		name = "sub_category",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"category_id", "sub_category_name"})}
)
public class SubCategory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	@Column(name = "sub_category_id")
	private long m_id;

	/***/
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
	private Category m_category;

	/***/
	@Column(name = "sub_category_name", nullable = false)
	private String m_name;

	/***/
    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
	private List<Business> m_businesses;

	/***/
	public SubCategory() {
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
	 * @return Category
	 */
	public Category getCategory() {
		return m_category;
	}

	/**
	 *
	 * @param category String
	 */
	public void setCategory(final Category category) {
		this.m_category = category;
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
		return m_id + ", " + m_category.getId() + ", " + m_name;
	}
}
