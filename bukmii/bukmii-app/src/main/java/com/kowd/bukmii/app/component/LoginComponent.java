package com.kowd.bukmii.app.component;

import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import com.kowd.bukmii.app.aws.S3Upload;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.app.hibernate.dao.PhotoDao;
import com.kowd.bukmii.app.hibernate.dao.UserDao;
import com.kowd.bukmii.app.util.Crypt;
import com.kowd.bukmii.formbeans.ResponseFormBean;
import com.kowd.bukmii.hibernate.beans.Photo;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
public class LoginComponent extends BaseComponent {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(LoginComponent.class);

	/***/
	public LoginComponent() {
	}

	/**
	 * @param email String
	 * @param password String
	 * @return boolean
	 * @throws BukmiiException e
	 */
	public boolean authenticate(final String email,
					  		  	final String password) throws BukmiiException {
		boolean valid = false;
		final UserDao dao = new UserDao();
		try {
			final User user = dao.findByEmail(email);
			final String encryptedPwd = Crypt.encryptHexString(password);
			if (null != user && user.getPassword().equals(encryptedPwd)) {
				valid = true;
			}
			dao.commit();
		} catch (final HibernateException e) {
			LOGGER.error("An error occur during user login.", e);
			dao.rollback();
		} finally {
			dao.closeCurrentSession();
		}
		return valid;
	}

	/**
	 * @param email String
	 * @param password String
	 * @return ResponseFormBean
	 * @throws BukmiiException e
	 */
	public ResponseFormBean login(final String email,
					  		  	  final String password) throws BukmiiException {
		final ResponseFormBean formBean = new ResponseFormBean();
		final UserDao dao = new UserDao();
		try {
			final User user = dao.findByEmail(email);
			final String encryptedPwd = Crypt.encryptHexString(password);
			if (null != user && user.getPassword().equals(encryptedPwd)) {
				formBean.setStatus(201);
				formBean.setData(toFormBean(user));
			} else {
				formBean.setStatus(403);
				formBean.setMessage("Invalid email or password.");
			}
			dao.commit();
		} catch (final HibernateException e) {
			LOGGER.error("An error occur during user login.", e);
			dao.rollback();
			formBean.setStatus(403);
			formBean.setMessage("An error occur during user login.");
		} finally {
			dao.closeCurrentSession();
		}
		return formBean;
	}

	/**
	 * @param email String
	 * @param firstName String
	 * @param lastName String
	 * @param phoneNumber String
	 * @param password String
	 * @param base64Img String
	 * @param imgType String
	 * @return ResponseFormBean
	 * @throws BukmiiException e
	 */
	public ResponseFormBean signUp(final String email,
							   	   final String firstName,
							   	   final String lastName,
							   	   final String phoneNumber,
							   	   final String password,
							   	   final String base64Img,
							   	   final String imgType) throws BukmiiException {
		final ResponseFormBean formBean = new ResponseFormBean();
		final UserDao dao = new UserDao();
		try {
			User user = dao.findByEmail(email);
			if (null != user) {
				formBean.setStatus(403);
				formBean.setMessage("Email already exist.");
				return formBean;
			}

			user = new User();
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhoneNumber(nullToEmpty(phoneNumber));
			user.setPassword(Crypt.encryptHexString(password));

			if (!isNullToEmpty(base64Img)) {

				final PhotoDao photoDao = new PhotoDao(dao.getCurrentSession(), dao.getCurrentTransaction());
				final Photo photo = photoDao.addNew(imgType);

				final byte[] img = Base64.getDecoder().decode(base64Img);
				final S3Upload s3Upload = new S3Upload();
				s3Upload.uploadPhoto(photo, img);

				user.setImage(photo);
			}

			dao.signUp(user);

			dao.commit();
		} catch (final HibernateException e) {
			LOGGER.error("An error occur during user login.", e);
			dao.rollback();
		} finally {
			dao.closeCurrentSession();
		}
		return formBean;
	}

}
