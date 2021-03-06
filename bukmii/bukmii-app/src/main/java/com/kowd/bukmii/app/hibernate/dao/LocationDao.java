package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class LocationDao extends LocationGenDao {

	/***/
	public LocationDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public LocationDao(final Session currentSession,
			 		   final Transaction currentTransaction) {
		super(LocationDao.class, currentSession, currentTransaction);
	}

}
