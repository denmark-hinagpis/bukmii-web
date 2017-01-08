package com.kowd.bukmii.ui.rest.common;

import java.io.Serializable;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.formbeans.ResponseFormBean;

/**
 * @author dchinagpis
 *
 */
public abstract class AbstractBaseResource {

	/***/
	private final Logger m_logger;

	/**
	 * @param clazz Class< ? extends AbstractBaseResource>
	 */
	protected AbstractBaseResource(final Class< ? extends AbstractBaseResource> clazz) {
		m_logger = LogManager.getLogger(clazz);
	}

	/**
	 * @return Logger
	 */
	protected Logger getLogger() {
		return m_logger;
	}

	/**
	 * @param status int
	 * @param message String
	 * @param data Serializable
	 * @return Reponse
	 */
	protected Response okResponse(final int status, final String message, final Serializable data) {
		return Response.ok(new ResponseFormBean(status, message, data), MediaType.APPLICATION_JSON).build();
	}

	/**
	 * @param ex BukmiiException
	 * @return Response
	 */
	protected Response toResponse(final BukmiiException ex) {
		return Response.status(ex.getStatus())
				.entity(ex)
				.type(MediaType.APPLICATION_JSON).
				build();
	}

}
