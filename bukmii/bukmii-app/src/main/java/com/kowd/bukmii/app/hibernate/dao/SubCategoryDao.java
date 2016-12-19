package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class SubCategoryDao extends SubCategoryGenDao {

	/***/
	public SubCategoryDao() {
		this(null, null);
	}

	/**
	 *
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public SubCategoryDao(final Session currentSession,
			 		   	  final Transaction currentTransaction) {
		super(SubCategoryDao.class, currentSession, currentTransaction);
	}

}
