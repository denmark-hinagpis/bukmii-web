package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Post;

/**
 * @author dchinagpis
 *
 */
class PostGenDao extends AbstractBaseDao implements DaoInterface<Post, Long> {

	/**
	 * @param clazz Class< ? extends PostGenDao>
	 */
	protected PostGenDao(final Class< ? extends PostGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends PostGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected PostGenDao(final Class< ? extends PostGenDao> clazz,
						 final Session currentSession,
						 final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(Post.class);
	}

	@Override
	public Serializable save(final Post entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final Post entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public Post findById(final Long id) {
		return (Post) super.findEntityById(Post.class, id);
	}

	@Override
	public void delete(final Post entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAll() {
		return (List<Post>) super.getAllEntity(Post.class);
	}

}
