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
public class BusinessIdGenerator implements IdentifierGenerator {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(BusinessIdGenerator.class);

	/***/
	private String m_defaultPrefix = "business-";

	@Override
	public final Serializable generate(final SessionImplementor session,
								 final Object arg1) throws HibernateException {
		final Connection con = session.connection();
		try {
			return getBusinessId(con);
		} catch (final SQLException e) {
			LOGGER.error("Failed to generate Business Id.", e);
		}
		return m_defaultPrefix.concat(RandomGenerator.rand8Char());
	}

	/**
	 *
	 * @param con Connection
	 * @return String
	 * @throws SQLException - sql runtime exception
	 */
	private String getBusinessId(final Connection con) throws SQLException {
		final String newBusinessId = m_defaultPrefix.concat(RandomGenerator.rand8Char());
		final PreparedStatement pst = con.prepareStatement("select business_id from business where business_id = ?");
		pst.setString(1, newBusinessId);
		final ResultSet rs = pst.executeQuery();
		if (rs != null && rs.next()) {
			return getBusinessId(con);
		} else {
			return newBusinessId;
		}
	}

}
