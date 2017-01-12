package com.kowd.bukmii.app.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kowd.bukmii.app.hibernate.connection.SessionFactoryUtil;

/**
 *
 * @author dhinagpis
 *
 */
abstract class AbstractBaseDao {

	/***/
	private final Logger m_logger;

	/***/
	private Session m_currentSession;

	/***/
	private Transaction m_currentTransaction;

	/**
	 * @param clazz Class< ? extends AbstractBaseDao>
	 * @param currentSession Session
	 * @param currentTransaction Transaction
	 */
	protected AbstractBaseDao(final Class< ? extends AbstractBaseDao> clazz,
							  final Session currentSession,
							  final Transaction currentTransaction) {
		this.m_logger = LogManager.getLogger(clazz);
		this.m_currentSession = currentSession;
		this.m_currentTransaction = currentTransaction;
	}

	/**
	 *
	 * @return Criteria
	 */
	protected abstract Criteria createCriteria();

	/***/
	private void openNewSessionwithTransaction() {
		m_currentSession = SessionFactoryUtil.getInstance().openSession();
		m_currentTransaction = m_currentSession.beginTransaction();
	}

	/***/
	public void commit() {
		if (null != m_currentTransaction && m_currentTransaction.isActive()) {
			m_currentTransaction.commit();
		}
	}

	/***/
	public void flush() {
		if (null != m_currentSession && m_currentSession.isConnected()) {
			m_currentSession.flush();
		}
	}

	/***/
	public void rollback() {
		if (null != m_currentTransaction) {
			m_currentTransaction.rollback();
		}
	}

	/***/
	public void closeCurrentSession() {
		if (null != m_currentSession) {
			m_currentSession.close();
		}
	}

	/**
	 *
	 * @return Session
	 */
	public Session getCurrentSession() {
		if (null == m_currentSession || !m_currentSession.isConnected()) {
			openNewSessionwithTransaction();
		}
		return m_currentSession;
	}

	/**
	 *
	 * @return Transaction
	 */
	public Transaction getCurrentTransaction() {
		return m_currentTransaction;
	}

	/**
	 * @param value String
	 * @return boolean
	 */
	protected boolean isNullOrEmpty(final String value) {
		if (null == value || value.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @param clazz Class< ? extends Serializable>
	 * @param id Serializable
	 * @return Object
	 */
	protected Object findEntityById(final Class< ? extends Serializable> clazz,
									final Serializable id) {
		return getCurrentSession().get(clazz, id);
	}

	/**
	 *
	 * @param obj Object
	 * @return Serializable
	 */
	protected Serializable saveEntity(final Object obj) {
		return getCurrentSession().save(obj);
	}

	/**
	 * @param obj Object
	 */
	protected void persistEntity(final Object obj) {
		getCurrentSession().persist(obj);
	}

	/**
	 * @param obj Object
	 */
	protected void deleteEntity(final Object obj) {
		getCurrentSession().delete(obj);
	}

	/**
	 * @param clazz Class< ? extends Serializable>
	 * @return List< ? extends Serializable>
	 */
	@SuppressWarnings("unchecked")
	protected List< ? extends Serializable> getAllEntity(final Class< ? extends Serializable> clazz) {
		final Criteria criteria = getCurrentSession().createCriteria(clazz);
		criteria.setReadOnly(true);
		return criteria.list();
	}

	/**
	 * @param message String
	 */
	protected void debug(final String message) {
		m_logger.debug(message);
	}

	/**
	 * @param message String
	 * @param t Throwable
	 */
	protected void debug(final String message, final Throwable t) {
		m_logger.debug(message, t);
	}

	/**
	 * @param message String
	 */
	protected void info(final String message) {
		m_logger.info(message);
	}

	/**
	 * @param message String
	 * @param t Throwable
	 */
	protected void info(final String message, final Throwable t) {
		m_logger.info(message, t);
	}

	/**
	 * @param message String
	 */
	protected void warn(final String message) {
		m_logger.warn(message);
	}

	/**
	 * @param message String
	 * @param t Throwable
	 */
	protected void warn(final String message, final Throwable t) {
		m_logger.warn(message, t);
	}

	/**
	 * @param message String
	 */
	protected void error(final String message) {
		m_logger.error(message);
	}

	/**
	 * @param message String
	 * @param t Throwable
	 */
	protected void error(final String message, final Throwable t) {
		m_logger.error(message, t);
	}
}
