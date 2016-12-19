package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class PostDao extends PostGenDao {

	/***/
	public PostDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public PostDao(final Session currentSession,
			 	   final Transaction currentTransaction) {
		super(PostDao.class, currentSession, currentTransaction);
	}

}
