package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.hibernate.beans.Location;

/**
 * @author dchinagpis
 *
 */
class LocationGenDao extends AbstractBaseDao implements DaoInterface<Location, Long> {

	/**
	 * @param clazz Class< ? extends LocationGenDao>
	 */
	protected LocationGenDao(final Class< ? extends LocationGenDao> clazz) {
		super(clazz, null, null);
	}

	/**
	 * @param clazz Class< ? extends LocationGenDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected LocationGenDao(final Class< ? extends LocationGenDao> clazz,
						     final Session currentSession,
						     final Transaction currentTransaction) {
		super(clazz, currentSession, currentTransaction);
	}

	@Override
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(Location.class);
	}

	@Override
	public Serializable save(final Location entity) {
		return super.saveEntity(entity);
	}

	@Override
	public void persist(final Location entity) {
		entity.setUpdateDate(new Date());
		super.persistEntity(entity);
	}

	@Override
	public Location findById(final Long id) {
		return (Location) super.findEntityById(Location.class, id);
	}

	@Override
	public void delete(final Location entity) {
		super.deleteEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAll() {
		return (List<Location>) super.getAllEntity(Location.class);
	}

}
