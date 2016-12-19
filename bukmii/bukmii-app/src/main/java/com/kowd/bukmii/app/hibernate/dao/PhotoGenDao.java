package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Photo;

/**
 * @author dchinagpis
 *
 */
class PhotoGenDao extends AbstractBaseDao implements DaoInterface<Photo, Long> {

	/**
	 * @param clazz Class< ? extends PhotoGenDao>
	 */
	protected PhotoGenDao(final Class< ? extends PhotoGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends PhotoGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected PhotoGenDao(final Class< ? extends PhotoGenDao> clazz,
						  final Session currentSession,
						  final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(Photo.class);
	}

	@Override
	public Serializable save(final Photo entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final Photo entity) {
		super.persistEntity(entity);
	}

	@Override
	public Photo findById(final Long id) {
		return (Photo) super.findEntityById(Photo.class, id);
	}

	@Override
	public void delete(final Photo entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getAll() {
		return (List<Photo>) super.getAllEntity(Photo.class);
	}

}
