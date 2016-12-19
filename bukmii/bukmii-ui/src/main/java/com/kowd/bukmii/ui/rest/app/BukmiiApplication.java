package com.kowd.bukmii.ui.rest.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.kowd.bukmii.ui.rest.filter.BukmiiAuthFilter;

/**
 * @author dchinagpis
 *
 */
@ApplicationPath("rest")
public class BukmiiApplication extends ResourceConfig {

	/***/
	public BukmiiApplication() {
		packages(false, "com.kowd.bukmii.ui.rest.services");
		register(BukmiiAuthFilter.class);
	}
}
