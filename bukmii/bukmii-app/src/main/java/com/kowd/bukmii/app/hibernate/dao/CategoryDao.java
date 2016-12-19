package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class CategoryDao extends CategoryGenDao {

	/***/
	public CategoryDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public CategoryDao(final Session currentSession,
			 		   final Transaction currentTransaction) {
		super(CategoryDao.class, currentSession, currentTransaction);
	}

}
