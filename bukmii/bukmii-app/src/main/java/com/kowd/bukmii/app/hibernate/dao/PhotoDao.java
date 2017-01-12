package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Photo;
import com.kowd.bukmii.hibernate.generator.RandomGenerator;

/**
 * @author dchinagpis
 *
 */
public class PhotoDao extends PhotoGenDao {

	/***/
	public PhotoDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public PhotoDao(final Session currentSession,
			 		final Transaction currentTransaction) {
		super(PhotoDao.class, currentSession, currentTransaction);
	}

	/**
	 * @param imgType String
	 * @return Photo
	 */
	public Photo addNew(final String imgType) {
		final Photo photo = new Photo();
		photo.setFileName(RandomGenerator.getRandString());
		photo.setFileType(imgType);
		save(photo);
		flush();
		return photo;
	}

}
