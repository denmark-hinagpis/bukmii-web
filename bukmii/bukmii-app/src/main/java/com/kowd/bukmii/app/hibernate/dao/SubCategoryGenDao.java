package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.SubCategory;

/**
 * @author dchinagpis
 *
 */
class SubCategoryGenDao extends AbstractBaseDao implements DaoInterface<SubCategory, Long> {

	/**
	 *
	 * @param clazz Class<? extends SubCategoryGenDao>
	 */
	protected SubCategoryGenDao(final Class< ? extends SubCategoryGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends SubCategoryGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected SubCategoryGenDao(final Class< ? extends SubCategoryGenDao> clazz,
						 		final Session currentSession,
						 		final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(SubCategory.class);
	}

	@Override
	public Serializable save(final SubCategory entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final SubCategory entity) {
		super.persistEntity(entity);
	}

	@Override
	public SubCategory findById(final Long id) {
		return (SubCategory) super.findEntityById(SubCategory.class, id);
	}

	@Override
	public void delete(final SubCategory entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> getAll() {
		return (List<SubCategory>) super.getAllEntity(SubCategory.class);
	}

}
