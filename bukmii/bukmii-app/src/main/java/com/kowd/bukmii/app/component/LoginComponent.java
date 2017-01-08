package com.kowd.bukmii.app.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.app.hibernate.dao.UserDao;
import com.kowd.bukmii.formbeans.UserFormBean;
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
		super(LoginComponent.class);
	}

	/**
	 * @param email String
	 * @param encryptedPwd String
	 * @return boolean
	 * @throws BukmiiException e
	 */
	public boolean authenticate(final String email,
					  		  	final String encryptedPwd) throws BukmiiException {
		boolean valid = false;
		final UserDao dao = new UserDao();
		try {
			final User user = dao.findByEmail(email);
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
	 * @param encryptedPwd String
	 * @return UserFormBean
	 * @throws BukmiiException e
	 */
	public UserFormBean login(final String email,
					  		  final String encryptedPwd) throws BukmiiException {
		final UserDao dao = new UserDao();
		try {
			final User user = dao.findByEmail(email);
			if (null != user && user.getPassword().equals(encryptedPwd)) {
				dao.commit();
				return toFormBean(user);
			} else {
				throw new BukmiiException("Invalid email or password.", 403);
			}
		} catch (final HibernateException e) {
			LOGGER.error("An error occur during user login.", e);
			dao.rollback();
			throw new BukmiiException("An error occur during user login.", 403);
		} finally {
			dao.closeCurrentSession();
		}
	}

}
