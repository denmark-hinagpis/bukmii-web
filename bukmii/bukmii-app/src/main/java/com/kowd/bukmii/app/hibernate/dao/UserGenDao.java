package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
class UserGenDao extends AbstractBaseDao implements DaoInterface<User, Long> {

	/***
	 *
	 * @param clazz Class<? extends UserGenDao>
	 */
	protected UserGenDao(final Class< ? extends UserGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 *
	 * @param clazz Class<? extends UserGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected UserGenDao(final Class< ? extends UserGenDao> clazz,
						 final Session currentSession,
						 final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(User.class);
	}

	@Override
	public Serializable save(final User entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final User entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public User findById(final Long id) {
		return (User) super.findEntityById(User.class, id);
	}

	@Override
	public void delete(final User entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return (List<User>) super.getAllEntity(User.class);
	}

}
