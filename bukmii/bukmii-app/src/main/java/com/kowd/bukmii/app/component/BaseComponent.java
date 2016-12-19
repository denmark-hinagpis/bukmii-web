package com.kowd.bukmii.app.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kowd.bukmii.enumeration.PictureSize;
import com.kowd.bukmii.formbeans.PhotoFormBean;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.hibernate.beans.Photo;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
class BaseComponent {

	/**
	 * @param value long
	 * @return String
	 */
	protected String stringValueOf(final long value) {
		return String.valueOf(value);
	}

	/**
	 * @param value int
	 * @return String
	 */
	protected String stringValueOf(final int value) {
		return String.valueOf(value);
	}

	/**
	 * @param value String
	 * @return String
	 */
	protected String nullToEmpty(final String value) {
		if (null == value) {
			return "";
		}
		return value;
	}

	/**
	 * @param value String
	 * @return boolean
	 */
	protected boolean isNullToEmpty(final String value) {
		if (null == value) {
			return true;
		}

		if (value.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * @param value Date
	 * @return String
	 */
	protected String toMillisSec(final Date value) {
		return stringValueOf(value.getTime());
	}

	/**
	 * @param user User
	 * @return UserFormBean
	 */
	protected UserFormBean toFormBean(final User user) {
		if (null == user) {
			return null;
		} else {
			return new UserFormBean(user.getId(),
					user.getUserName(),
					user.getEmail(),
					user.getFirstName(),
					user.getLastName(),
					nullToEmpty(user.getPhoneNumber()),
					user.getPasscode(),
					nullToEmpty(user.getAbout()),
					toFormBean(user.getImage()),
					toMillisSec(user.getCreateDate()),
					toMillisSec(user.getUpdateDate()));
		}
	}

	/**
	 * @param photo Photo
	 * @return PhotoFormBean
	 */
	protected PhotoFormBean toFormBean(final Photo photo) {
		if (null == photo) {
			return new PhotoFormBean("-1", "", "", "", new ArrayList<>(), null, null);
		} else {
			final List<String> likedId = new ArrayList<>();
			for (final User like : photo.getLikes()) {
				likedId.add(like.getId());
			}

			return new PhotoFormBean(stringValueOf(photo.getId()),
									 photo.getImagePath(PictureSize.THUMB),
									 photo.getImagePath(PictureSize.MEDIUM),
									 photo.getImagePath(PictureSize.ORIGINAL),
									 likedId,
									 stringValueOf(photo.getCreateDate().getTime()),
									 stringValueOf(photo.getUpdateDate().getTime()));
		}
	}

}
