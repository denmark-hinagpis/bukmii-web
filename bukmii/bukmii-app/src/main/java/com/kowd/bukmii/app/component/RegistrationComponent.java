package com.kowd.bukmii.app.component;

import java.text.SimpleDateFormat;

import com.kowd.bukmii.app.hibernate.dao.UserDao;
import com.kowd.bukmii.enumeration.PictureSize;
import com.kowd.bukmii.formbeans.PhotoFormBean;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
public class RegistrationComponent extends BaseComponent {

	/**
	 * @param email String
	 * @param password String
	 * @param firstName String
	 * @param lastName String
	 * @return UserFormBean
	 */
	public UserFormBean signUp(final String email,
							   final String password,
							   final String firstName,
							   final String lastName) {

		final User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		final UserDao dao = new UserDao();
		final String id = dao.signUp(user);

		user.setId(id);
		return convertBeanToFormBean(user);
	}

	/**
	 * @param user User
	 * @return UserFormBean
	 */
	private UserFormBean convertBeanToFormBean(final User user) {
		final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		final PhotoFormBean photo = new PhotoFormBean(String.valueOf(user.getImage().getId()),
													  user.getImage().getImagePath(PictureSize.THUMB),
													  user.getImage().getImagePath(PictureSize.MEDIUM),
													  user.getImage().getImagePath(PictureSize.ORIGINAL),
													  null,
													  sdf.format(user.getImage().getCreateDate()),
													  sdf.format(user.getImage().getUpdateDate()));
		return new UserFormBean(user.getId(),
								user.getUserName(),
								user.getEmail(),
								user.getFirstName(),
								user.getLastName(),
								user.getPhoneNumber(),
								user.getPasscode(),
								user.getAbout(),
								photo,
								sdf.format(user.getCreateDate()),
								sdf.format(user.getUpdateDate()));
	}
}
