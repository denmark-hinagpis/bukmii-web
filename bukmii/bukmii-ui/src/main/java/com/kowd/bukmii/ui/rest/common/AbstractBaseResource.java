/**
 *
 */
package com.kowd.bukmii.ui.rest.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author dchinagpis
 *
 */
public class AbstractBaseResource {

	/***/
	private final Log m_logger;

	/***/
	protected AbstractBaseResource(final Class< ? extends AbstractBaseResource> clazz) {
		m_logger = LogFactory.getLog(clazz);
	}

	/**
	 * @return Log
	 */
	protected Log getLogger() {
		return m_logger;
	}

}
