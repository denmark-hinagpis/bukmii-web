package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class BusinessDao extends BusinessGenDao {

	/***/
	public BusinessDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public BusinessDao(final Session currentSession,
			 		   final Transaction currentTransaction) {
		super(BusinessDao.class, currentSession, currentTransaction);
	}

}
