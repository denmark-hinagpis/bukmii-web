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
public class PostIdGenerator implements IdentifierGenerator {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(PostIdGenerator.class);

	/***/
	private String m_defaultPrefix = "post-";

	@Override
	public final Serializable generate(final SessionImplementor session, final Object arg1) throws HibernateException {
		final Connection con = session.connection();
		try {
			return getPostId(con);
		} catch (final SQLException e) {
			LOGGER.error("Failed to generate User Id.", e);
		}
		return m_defaultPrefix + RandomGenerator.getRandString();
	}

	/**
	 *
	 * @param con Connection
	 * @return String
	 * @throws SQLException - sql runtime exception
	 */
	private String getPostId(final Connection con) throws SQLException {
		final String newPostId = m_defaultPrefix + RandomGenerator.rand8Char();
		final PreparedStatement pst = con.prepareStatement("select post_id from post where post_id = ?");
		pst.setString(1, newPostId);
		final ResultSet rs = pst.executeQuery();
		if (rs != null && rs.next()) {
			return getPostId(con);
		} else {
			return newPostId;
		}
	}

}
