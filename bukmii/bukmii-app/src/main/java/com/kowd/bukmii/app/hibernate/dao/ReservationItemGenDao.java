package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.ReservationItem;
import com.kowd.bukmii.hibernate.beans.ReservationItemPk;

/**
 * @author dchinagpis
 *
 */
class ReservationItemGenDao extends AbstractBaseDao implements DaoInterface<ReservationItem, ReservationItemPk> {

	/**
	 * @param clazz Class< ? extends ReservationItemGenDao>
	 */
	protected ReservationItemGenDao(final Class< ? extends ReservationItemGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends ReservationItemGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected ReservationItemGenDao(final Class< ? extends ReservationItemGenDao> clazz,
						 	 		final Session currentSession,
						 	 		final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(ReservationItem.class);
	}

	@Override
	public Serializable save(final ReservationItem entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final ReservationItem entity) {
		super.persistEntity(entity);
	}

	@Override
	public ReservationItem findById(final ReservationItemPk id) {
		return (ReservationItem) super.findEntityById(ReservationItem.class, id);
	}

	@Override
	public void delete(final ReservationItem entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationItem> getAll() {
		return (List<ReservationItem>) super.getAllEntity(ReservationItem.class);
	}

}
