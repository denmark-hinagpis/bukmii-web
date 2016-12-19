package com.kowd.bukmii.ui.services;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author dchinagpis
 *
 */
@Path("/search")
public class SearchResource {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(SearchResource.class);

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param userName String
	 * @throws ServletException e
	 * @throws IOException e
	 */
	@GET
	@PermitAll
	@Path("/{username: [a-z][a-z_\\.0-9]*}")
	@Produces(MediaType.TEXT_HTML)
	public void searchWeb(@Context final HttpServletRequest request,
					 	  @Context final HttpServletResponse response,
					 	  @PathParam(value = "username") final String userName) throws ServletException, IOException {
		request.setAttribute("userName", userName);
		LOGGER.info("userName: " + userName);
		request.getRequestDispatcher("/templates/search.jsp").forward(request, response);
	}

}
