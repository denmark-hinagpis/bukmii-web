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
public class UserFormBean extends BaseFormBean implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	/***/
	@XmlElement(name = "id", required = true)
	private String m_id;

	/***/
	@XmlElement(name = "userName", required = true)
	private String m_userName;

	/***/
	@XmlElement(name = "email", required = true)
	private String m_email;

	/***/
	@XmlElement(name = "firstName", required = true)
	private String m_firstName;

	/***/
	@XmlElement(name = "lastName", required = true)
	private String m_lastName;

	/***/
	@XmlElement(name = "phoneNumber", required = false)
	private String m_phoneNumber;

	/***/
	@XmlElement(name = "passcode", required = false)
	private String m_passcode;

	/***/
	@XmlElement(name = "about", required = false)
	private String m_about;

	/***/
	@XmlElement(name = "image", required = false)
	private PhotoFormBean m_image;

	/**
	 * @param id String
	 * @param userName String
	 * @param email String
	 * @param firstName String
	 * @param lastName String
	 * @param phoneNumber String
	 * @param passcode String
	 * @param about String
	 * @param image PhotoFormBean
	 * @param createDate String
	 * @param updateDate String
	 */
	public UserFormBean(final String id,
						final String userName,
						final String email,
						final String firstName,
						final String lastName,
						final String phoneNumber,
						final String passcode,
						final String about,
						final PhotoFormBean image,
						final String createDate,
						final String updateDate) {
		super(createDate, updateDate);
		this.m_id = id;
		this.m_userName = userName;
		this.m_email = email;
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.m_phoneNumber = phoneNumber;
		this.m_passcode = passcode;
		this.m_about = about;
		this.m_image = image;
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
	public String getUserName() {
		return m_userName;
	}

	/**
	 *
	 * @param userName String
	 */
	public void setUserName(final String userName) {
		this.m_userName = userName;
	}

	/**
	 *
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
		this.m_email = email;
	}

	/**
	 *
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
		this.m_firstName = firstName;
	}

	/**
	 *
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
		this.m_lastName = lastName;
	}

	/**
	 *
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
		this.m_phoneNumber = phoneNumber;
	}

	/**
	 *
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
		this.m_passcode = passcode;
	}

	/**
	 *
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
		this.m_about = about;
	}

	/**
	 *
	 * @return PhotoFormBean
	 */
	public PhotoFormBean getImage() {
		return m_image;
	}

	/**
	 *
	 * @param image PhotoFormBean
	 */
	public void setImage(final PhotoFormBean image) {
		this.m_image = image;
	}

	@Override
	public final String toString() {
		return m_id + ", " + m_userName + ", " + m_email + ", " + m_firstName + ", " +
				m_lastName + ", " + m_phoneNumber + ", " +
				m_passcode + ", " + m_about + ", " + m_image;
	}
}
