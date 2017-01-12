package com.kowd.bukmii.app.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kowd.bukmii.hibernate.beans.BusinessContacts;

/**
 * @author dchinagpis
 *
 */
public class BusinessContactsDao extends BusinessContactsGenDao {

	/****/
	public BusinessContactsDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public BusinessContactsDao(final Session currentSession,
			 				   final Transaction currentTransaction) {
		super(BusinessContactsDao.class, currentSession, currentTransaction);
	}

	/**
	 * @param businessId int
	 * @return List<BusinessContacts>
	 */
	@SuppressWarnings("unchecked")
	public List<BusinessContacts> getContact(final int businessId) {
		final Criteria criteria = createCriteria();
		criteria.setFetchMode("m_business", FetchMode.JOIN);
		criteria.createCriteria("m_business", "m_business");
		criteria.add(Restrictions.eq("m_business.m_id", businessId));
		return criteria.list();
	}

}
