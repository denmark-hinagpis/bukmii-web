package com.kowd.bukmii.ui.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.kowd.bukmii.ui.rest.common.AbstractBaseResource;

/**
 * @author dchinagpis
 *
 */
@Path("/register")
public class RegistrationResource extends AbstractBaseResource {

	/***/
//	private static final Logger LOGGER = LogManager.getLogger(RegistrationResource.class);

	/**
	 * @param clazz
	 */
	protected RegistrationResource() {
		super(RegistrationResource.class);
	}

	/**
	 *
	 * @param user JSONObject
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/signup")
	@Produces(MediaType.TEXT_HTML)
	public Response signUp(@QueryParam(value = "user") final JSONObject user) {
		final String username = user.get("username").toString();
		if (null != username && !"".equals(username)) {
			//
			System.out.println();
		}
		user.get("password");

//		final RegistrationComponent comp = new RegistrationComponent();
		return null;
//		return comp.signUp(email, password, firstName, lastName);
	}

}
