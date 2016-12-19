package com.kowd.bukmii.hibernate.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author dchinagpis
 *
 */
public class UserIdGenerator implements IdentifierGenerator {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(UserIdGenerator.class);

	/***/
	private String m_defaultPrefix = "user-";

	@Override
	public final Serializable generate(final SessionImplementor session, final Object arg1) throws HibernateException {
		final Connection con = session.connection();
		try {
			return getUserId(con);
		} catch (final SQLException e) {
			LOGGER.error("Failed to generate User Id.", e);
		}
		return m_defaultPrefix.concat(RandomGenerator.rand8Char());
	}

	/**
	 *
	 * @param con Connection
	 * @return String
	 * @throws SQLException - sql runtime exception
	 */
	private String getUserId(final Connection con) throws SQLException {
		final String newUserId = m_defaultPrefix.concat(RandomGenerator.rand8Char());
		final PreparedStatement pst = con.prepareStatement("select user_id from user where user_id = ?");
		pst.setString(1, newUserId);
		final ResultSet rs = pst.executeQuery();
		if (rs != null && rs.next()) {
			return getUserId(con);
		} else {
			return newUserId;
		}
	}

}
