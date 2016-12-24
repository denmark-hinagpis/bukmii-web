package com.kowd.bukmii.app.component;

import java.text.SimpleDateFormat;

import com.kowd.bukmii.app.hibernate.dao.UserDao;
import com.kowd.bukmii.app.util.Crypt;
import com.kowd.bukmii.enumeration.PictureSize;
import com.kowd.bukmii.formbeans.PhotoFormBean;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
public class UserComponent extends BaseComponent {

	/**
	 * @param email String
	 * @param password String
	 * @return UserFormBean
	 */
//bow

	public UserFormBean login(final String email, final String password) {
		final UserDao dao = new UserDao();
		final User user = dao.findByEmail(email);
		final String encryptedPass = Crypt.encryptHexString(password);
		if (null != user && user.getPassword().equals(encryptedPass)) {
			return convertBeanToFormBean(user);
		}

		//sample changes

		return null;
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
