package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.ReservationHistory;
import com.kowd.bukmii.hibernate.beans.ReservationHistoryPk;

/**
 * @author dchinagpis
 *
 */
class ReservationHistoryGenDao extends AbstractBaseDao implements DaoInterface<ReservationHistory, ReservationHistoryPk> {

	/**
	 * @param clazz Class< ? extends ReservationHistoryGenDao>
	 */
	protected ReservationHistoryGenDao(final Class< ? extends ReservationHistoryGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends ReservationHistoryGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected ReservationHistoryGenDao(final Class< ? extends ReservationHistoryGenDao> clazz,
						 	 		   final Session currentSession,
						 	 		   final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(ReservationHistory.class);
	}

	@Override
	public Serializable save(final ReservationHistory entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final ReservationHistory entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public ReservationHistory findById(final ReservationHistoryPk id) {
		return (ReservationHistory) super.findEntityById(ReservationHistory.class, id);
	}

	@Override
	public void delete(final ReservationHistory entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationHistory> getAll() {
		return (List<ReservationHistory>) super.getAllEntity(ReservationHistory.class);
	}

}
