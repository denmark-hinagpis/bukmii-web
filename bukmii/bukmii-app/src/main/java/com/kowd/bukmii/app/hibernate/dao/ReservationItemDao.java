package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class ReservationItemDao extends ReservationItemGenDao {

	/***/
	public ReservationItemDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public ReservationItemDao(final Session currentSession,
			 		   		  final Transaction currentTransaction) {
		super(ReservationItemDao.class, currentSession, currentTransaction);
	}

}
