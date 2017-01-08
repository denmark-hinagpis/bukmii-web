package com.kowd.bukmii.app.component;

import java.util.Base64;

import org.hibernate.HibernateException;

import com.kowd.bukmii.app.aws.S3Upload;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.app.hibernate.dao.PhotoDao;
import com.kowd.bukmii.app.hibernate.dao.UserDao;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.hibernate.beans.Photo;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
public class RegistrationComponent extends BaseComponent {

	/***/
	public RegistrationComponent() {
		super(RegistrationComponent.class);
	}

	/**
	 * @param email String
	 * @param firstName String
	 * @param lastName String
	 * @param phoneNumber String
	 * @param password String
	 * @param base64Img String
	 * @param imgType String
	 * @return UserFormBean
	 * @throws BukmiiException e
	 */
	public UserFormBean signUp(final String email,
							   	   final String firstName,
							   	   final String lastName,
							   	   final String phoneNumber,
							   	   final String password,
							   	   final String base64Img,
							   	   final String imgType) throws BukmiiException {
		final UserDao dao = new UserDao();
		try {
			User user = dao.findByEmail(email);
			if (null != user) {
				throw new BukmiiException("User already exist.", 403);
			}

			user = new User();
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhoneNumber(nullToEmpty(phoneNumber));
			user.setPassword(password);

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

			return toFormBean(user);
		} catch (final HibernateException e) {
			getLogger().error("An error occur during user login.", e);
			dao.rollback();
			throw new BukmiiException("Error on user signup. please contact service administrator.", 403);
		} finally {
			dao.closeCurrentSession();
		}
	}

	/**
	 * @param email String
	 * @param firstName String
	 * @param lastName String
	 * @return UserFormBean
	 * @throws BukmiiException e
	 */
	public UserFormBean signUpFB(final String email,
								 final String firstName,
								 final String lastName) throws BukmiiException {
		final UserDao dao = new UserDao();
		try {
			User user = dao.findByEmail(email);
			if (null != user) {
				return toFormBean(user);
			}

			user = new User();
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);

			dao.signUp(user);
			dao.commit();

			return toFormBean(user);
		} catch (final HibernateException e) {
			getLogger().error("An error occur during user login.", e);
			dao.rollback();
			throw new BukmiiException("Error on user signup. please contact service administrator.", 403);
		} finally {
			dao.closeCurrentSession();
		}
	}
}
