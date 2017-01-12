package com.kowd.bukmii.formbeans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinagpis
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CategoryFormBean extends BaseFormBean implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	/***/
	@XmlElement(name = "id", required = true)
	private String m_id;

	/***/
	@XmlElement(name = "name", required = true)
	private String m_name;

	/***/
	@XmlElement(name = "color", required = true)
	private String m_color;

	/**
	 * @param id String
	 * @param name String
	 * @param color String
	 * @param createDate String
	 * @param updateDate String
	 */
	public CategoryFormBean(final String id,
							final String name,
							final String color,
							final String createDate,
							final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_name = name;
		this.m_color = color;
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
