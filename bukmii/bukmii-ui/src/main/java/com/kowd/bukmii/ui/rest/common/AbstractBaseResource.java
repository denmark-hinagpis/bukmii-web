package com.kowd.bukmii.ui.rest.common;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

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
		final ResponseFormBean bean = new ResponseFormBean(status, message, data);
		final JSONObject jsonResponse = new JSONObject(bean);
		return Response.status(201).entity(jsonResponse.toString()).build();
	}

	/**
	 * @param ex BukmiiException
	 * @return Response
	 */
	protected Response toResponse(final BukmiiException ex) {
		final ResponseFormBean bean = new ResponseFormBean(ex.getStatus(), ex.getMessage(), null);
		final JSONObject jsonResponse = new JSONObject(bean);
		return Response.status(ex.getStatus()).entity(jsonResponse.toString()).build();
	}

}
