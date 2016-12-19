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
public class PhotoFileNameGenerator implements IdentifierGenerator {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(PhotoFileNameGenerator.class);

	@Override
	public final Serializable generate(final SessionImplementor session, final Object arg1) throws HibernateException {
		final Connection con = session.connection();
		try {
			return getPhotoFileName(con);
		} catch (final SQLException e) {
			LOGGER.error("Failed to generate User Id.", e);
		}
		return RandomGenerator.getRandString();
	}

	/**
	 *
	 * @param con Connection
	 * @return String
	 * @throws SQLException - sql runtime exception
	 */
	private String getPhotoFileName(final Connection con) throws SQLException {
		final String newFileName = RandomGenerator.getRandString();
		final PreparedStatement pst = con.prepareStatement("select file_name from photo where file_name = ?");
		pst.setString(1, newFileName);
		final ResultSet rs = pst.executeQuery();
		if (rs != null && rs.next()) {
			return getPhotoFileName(con);
		} else {
			return newFileName;
		}
	}

}
