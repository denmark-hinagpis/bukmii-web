package com.kowd.bukmii.app.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.kowd.bukmii.hibernate.beans.User;
import com.kowd.bukmii.hibernate.generator.RandomGenerator;

/**
 * @author dchinagpis
 *
 */
public class UserDao extends UserGenDao {

	/***/
	public UserDao() {
		this(null, null);
	}

	/**
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	public UserDao(final Session currentSession,
			 	   final Transaction currentTransaction) {
		super(UserDao.class, currentSession, currentTransaction);
	}

	/**
	 *
	 * @param email String
	 * @return User
	 */
	@SuppressWarnings("unchecked")
	public User findByEmail(final String email) {
		final Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("email", email));
		criteria.setReadOnly(true);
		final List<User> list = criteria.list();
		if (null != list && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 *
	 * @param userName String
	 * @return User
	 */
	@SuppressWarnings("unchecked")
	public User findByUserName(final String userName) {
		final Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		criteria.setReadOnly(true);
		final List<User> list = criteria.list();
		if (null != list && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 *
	 * @param userName String
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean userNameExist(final String userName) {
		final Criteria criteria = createCriteria();
		criteria.setReadOnly(true);
		criteria.setProjection(Projections.distinct(Projections.id()));
		criteria.add(Restrictions.eq("userName", userName));
		final List<User> list = criteria.list();
		if (null != list && list.size() == 1) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param user User
	 */
	private void generateUserName(final User user) {
		final String userName = user.getEmail().substring(0, user.getEmail().lastIndexOf("@")).toLowerCase();
		String newUserName = userName;
		int index = 0;
		while (userNameExist(newUserName)) {
			index++;
			newUserName = userName + index;
		}
		user.setUserName(newUserName);
	}

	/**
	 *
	 * @param user User
	 */
	public String signUp(final User user) {
		user.setPasscode(RandomGenerator.getRandString());
		generateUserName(user);
		return (String) save(user);
	}

}
