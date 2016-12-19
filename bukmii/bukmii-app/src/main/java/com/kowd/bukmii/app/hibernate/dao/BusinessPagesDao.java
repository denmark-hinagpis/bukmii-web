package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class BusinessPagesDao extends BusinessPagesGenDao {

	/***/
	public BusinessPagesDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public BusinessPagesDao(final Session currentSession,
			 		   		final Transaction currentTransaction) {
		super(BusinessPagesDao.class, currentSession, currentTransaction);
	}

}
