package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Category;

/**
 * @author dchinagpis
 *
 */
class CategoryGenDao extends AbstractBaseDao implements DaoInterface<Category, Long> {

	/**
	 * @param clazz Class< ? extends CategoryGenDao>
	 */
	protected CategoryGenDao(final Class< ? extends CategoryGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends CategoryGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected CategoryGenDao(final Class< ? extends CategoryGenDao> clazz,
						     final Session currentSession,
						     final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(Category.class);
	}

	@Override
	public Serializable save(final Category entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final Category entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public Category findById(final Long id) {
		return (Category) super.findEntityById(Category.class, id);
	}

	@Override
	public void delete(final Category entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		return (List<Category>) super.getAllEntity(Category.class);
	}

}
