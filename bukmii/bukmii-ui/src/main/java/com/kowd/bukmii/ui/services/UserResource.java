package com.kowd.bukmii.ui.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kowd.bukmii.app.component.UserComponent;
import com.kowd.bukmii.formbeans.UserFormBean;

/**
 * @author dchinagpis
 *
 */
@Path("/user")
public class UserResource {

	/**
	 * @param email String
	 * @param password String
	 * @return Response
	 * @throws Exception e
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signUp(@QueryParam(value = "email") final String email,
						   @QueryParam(value = "password") final String password) throws Exception {
		if (null == email || "".equals(email)) {
			throw new Exception();
		}
		if (null == password || "".equals(password)) {
			throw new Exception();
		}

		final UserComponent comp = new UserComponent();
		final UserFormBean user = comp.login(email, password);
		if (null == user) {
			return Response.ok(user, MediaType.APPLICATION_JSON).build();
		}
		return Response.status(403).build();
	}

}
