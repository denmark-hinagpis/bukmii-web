package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.BusinessPages;
import com.kowd.bukmii.hibernate.beans.BusinessPagesPk;

/**
 * @author dchinagpis
 *
 */
class BusinessPagesGenDao extends AbstractBaseDao implements DaoInterface<BusinessPages, BusinessPagesPk> {

	/**
	 *
	 * @param clazz Class< ? extends BusinessPagesGenDao>
	 */
	protected BusinessPagesGenDao(final Class< ? extends BusinessPagesGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends BusinessPagesGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected BusinessPagesGenDao(final Class< ? extends BusinessPagesGenDao> clazz,
						     	  final Session currentSession,
						     	  final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(BusinessPages.class);
	}

	@Override
	public Serializable save(final BusinessPages entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final BusinessPages entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public BusinessPages findById(final BusinessPagesPk id) {
		return (BusinessPages) super.findEntityById(BusinessPages.class, id);
	}

	@Override
	public void delete(final BusinessPages entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessPages> getAll() {
		return (List<BusinessPages>) super.getAllEntity(BusinessPages.class);
	}

}
