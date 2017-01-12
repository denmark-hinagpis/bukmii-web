package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Business;

/**
 * @author dchinagpis
 *
 */
class BusinessGenDao extends AbstractBaseDao implements DaoInterface<Business, Long> {

	/**
	 * @param clazz Class< ? extends BusinessGenDao>
	 */
	protected BusinessGenDao(final Class< ? extends BusinessGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends BusinessGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected BusinessGenDao(final Class< ? extends BusinessGenDao> clazz,
						 	 final Session currentSession,
						 	 final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(Business.class);
	}

	@Override
	public Serializable save(final Business entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final Business entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public Business findById(final Long id) {
		return (Business) super.findEntityById(Business.class, id);
	}

	@Override
	public void delete(final Business entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business> getAll() {
		return (List<Business>) super.getAllEntity(Business.class);
	}

}
