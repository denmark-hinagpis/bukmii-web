package com.kowd.bukmii.ui.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kowd.bukmii.ui.servlet.common.ServletSettings;

/**
 *
 * @author dchinagpis
 *
 */
@WebListener
public class BukmiiContextListener implements ServletContextListener {

	@Override
	public final void contextInitialized(final ServletContextEvent event) {
		final ServletContext servletContext = event.getServletContext();
		final ServletSettings settings = new ServletSettings(servletContext);
		servletContext.setAttribute("settings", settings);

		//Initialize Database Connection
//		SessionFactoryUtil.initSessionFactory();
	}

	@Override
	public final void contextDestroyed(final ServletContextEvent event) {
		//Close Dataase Connection
//		SessionFactoryUtil.close();
	}
}
