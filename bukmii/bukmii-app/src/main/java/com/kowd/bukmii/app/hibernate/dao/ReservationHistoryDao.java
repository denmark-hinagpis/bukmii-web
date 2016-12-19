package com.kowd.bukmii.app.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author dchinagpis
 *
 */
public class ReservationHistoryDao extends ReservationHistoryGenDao {

	/***/
	public ReservationHistoryDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public ReservationHistoryDao(final Session currentSession,
			 		   			 final Transaction currentTransaction) {
		super(ReservationHistoryDao.class, currentSession, currentTransaction);
	}

}
