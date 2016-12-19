package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.BusinessContacts;
import com.kowd.bukmii.hibernate.beans.BusinessContactsPk;

/**
 * @author dchinagpis
 *
 */
class BusinessContactsGenDao extends AbstractBaseDao implements DaoInterface<BusinessContacts, BusinessContactsPk> {

	/**
	 * @param clazz Class< ? extends BusinessContactsGenDao>
	 */
	protected BusinessContactsGenDao(final Class< ? extends BusinessContactsGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends BusinessContactsGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected BusinessContactsGenDao(final Class< ? extends BusinessContactsGenDao> clazz,
									 final Session currentSession,
									 final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(BusinessContacts.class);
	}

	@Override
	public Serializable save(final BusinessContacts entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final BusinessContacts entity) {
		super.persistEntity(entity);
	}

	@Override
	public BusinessContacts findById(final BusinessContactsPk id) {
		return (BusinessContacts) super.findEntityById(BusinessContacts.class, id);
	}

	@Override
	public void delete(final BusinessContacts entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessContacts> getAll() {
		return (List<BusinessContacts>) super.getAllEntity(BusinessContacts.class);
	}

}
