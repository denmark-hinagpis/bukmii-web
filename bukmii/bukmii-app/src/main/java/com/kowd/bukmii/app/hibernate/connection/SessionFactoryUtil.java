package com.kowd.bukmii.app.hibernate.connection;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.kowd.bukmii.hibernate.beans.Business;
import com.kowd.bukmii.hibernate.beans.BusinessContacts;
import com.kowd.bukmii.hibernate.beans.BusinessPages;
import com.kowd.bukmii.hibernate.beans.Category;
import com.kowd.bukmii.hibernate.beans.Location;
import com.kowd.bukmii.hibernate.beans.Photo;
import com.kowd.bukmii.hibernate.beans.Post;
import com.kowd.bukmii.hibernate.beans.SubCategory;
import com.kowd.bukmii.hibernate.beans.User;

/**
 * @author dchinagpis
 *
 */
public final class SessionFactoryUtil {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(SessionFactoryUtil.class);

	/***/
	private static SessionFactory sessionFactory;

	/***/
	private SessionFactoryUtil() {

	}

	/**
	 *
	 */
	public static void initSessionFactory() {
		try {
			final Configuration configuration = new Configuration();

			configuration
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(SubCategory.class)

				.addAnnotatedClass(Photo.class)
				.addAnnotatedClass(Post.class)

				.addAnnotatedClass(User.class)

				.addAnnotatedClass(Location.class)

				.addAnnotatedClass(Business.class)
				.addAnnotatedClass(BusinessContacts.class)
				.addAnnotatedClass(BusinessPages.class);

//				.addAnnotatedClass(ReservationItem.class)
//				.addAnnotatedClass(Reservation.class)
//				.addAnnotatedClass(ReservationHistory.class);


			configuration.setProperty(Environment.DRIVER, "org.h2.Driver");
			configuration.setProperty(Environment.URL, "jdbc:h2:" + new File("C:\\Users\\dchinagpis\\Desktop\\SampleDb\\mdpdb").getPath());
			configuration.setProperty(Environment.USER, "sa");
			configuration.setProperty(Environment.PASS, "");

//			configuration.setProperty(Environment.DRIVER, "org.hibernate.dialect.PostgreSQLDialect");
//			configuration.setProperty(Environment.URL, "jdbc:postgresql://" + System.getProperty("RDS_HOSTNAME", "localhost") + ":" +
			//System.getProperty("RDS_PORT ", "5432") + "/" + System.getProperty("RDS_DB_NAME", "ebdb"));
//			configuration.setProperty(Environment.USER, System.getProperty("RDS_USERNAME", "bukmii"));
//			configuration.setProperty(Environment.PASS, System.getProperty("RDS_PASSWORD", ""));

	        configuration.setProperty(Environment.POOL_SIZE, "5");
			configuration.setProperty(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.internal.NoCacheProvider");

			configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
			configuration.setProperty("hibernate.connection.CharSet", "UTF-8");
			configuration.setProperty("hibernate.connection.characterEncoding", "UTF-8");
			configuration.setProperty("hibernate.connection.useUnicode", "true");
			configuration.setProperty(Environment.SHOW_SQL, "false");

			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			LOGGER.info("Current database connection initialized...");
		} catch (final HibernateException e) {
			LOGGER.error("Initial SessionFactory creation failed.", e);
			sessionFactory = null;
		}
	}

	/**
	 *
	 * @return SessionFactory
	 */
	public static SessionFactory getInstance() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			initSessionFactory();
		}
		return sessionFactory;
	}

	/***/
	public static void close() {
		if (null != sessionFactory) {
			sessionFactory.close();
		}
		LOGGER.info("Close current session...");
		sessionFactory = null;
	}

}
