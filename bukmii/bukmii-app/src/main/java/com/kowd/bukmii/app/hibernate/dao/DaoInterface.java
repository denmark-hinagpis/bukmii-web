package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dhinagpis
 *
 * @param <Bean>
 * @param <BeanPk>
 */
public interface DaoInterface<Bean extends Serializable, BeanPk extends Serializable> {

	/**
	 * Insert and Update Entity data.
	 * @param entity Bean
	 * @return Serializable
	 */
	Serializable save(Bean entity);

	/**
	 * Insert and Update Entity data.
	 * @param entity Bean
	 */
	void persist(Bean entity);

	/**
	 * Search by Id.
	 * @param id BeanPk
	 * @return Bean
	 */
	Bean findById(BeanPk id);

	/**
	 * Remove Entity data.
	 * @param entity Bean
	 */
	void delete(Bean entity);

	/**
	 * Get All Entity.
	 * @return List<Bean>
	 */
	List<Bean> getAll();
}
