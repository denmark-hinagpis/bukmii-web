package com.kowd.bukmii.ui.services;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.kowd.bukmii.app.component.RegistrationComponent;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.ui.rest.common.AbstractBaseResource;

/**
 * @author dchinagpis
 *
 */
@Path("/register")
public class RegistrationResource extends AbstractBaseResource {

	/***/
	public RegistrationResource() {
		super(RegistrationResource.class);
	}

	/**
	 *
	 * @param user JSONObject
	 * @return Response
	 */
	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signUp(@QueryParam(value = "user") final JSONObject user) {
		if (null == user) {
			return toResponse(new BukmiiException("Invalid parameters.", 403));
		}
		if (null == user.getString("first_name")) {
			return toResponse(new BukmiiException("Missing required parameter first name.", 403));
		}
		if (null == user.getString("last_name")) {
			return toResponse(new BukmiiException("Missing required parameter last name.", 403));
		}
		if (null == user.getString("email")) {
			return toResponse(new BukmiiException("Missing required parameter email.", 403));
		}

		final String firstName = user.getString("first_name");
		final String lastName = user.getString("last_name");
		final String email = user.getString("email");
		final String password = user.getString("password");
		final String phoneNumber = user.getString("phone_number");

		String image = null;
		if (null == user.getString("image")) {
			image = user.getString("image");
		}

		final RegistrationComponent comp = new RegistrationComponent();
		try {
			final UserFormBean bean = comp.signUp(email, firstName, lastName, phoneNumber, password, image, "jpeg");
			return okResponse(201, null, bean);
		} catch (final BukmiiException e) {
			return toResponse(e);
		}
	}

	/**
	 *
	 * @param user JSONObject
	 * @return Response
	 */
	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/signupfb")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signUpFB(@QueryParam(value = "user") final JSONObject user) {
		if (null == user) {
			return toResponse(new BukmiiException("Invalid parameters.", 403));
		}
		if (null == user.getString("email")) {
			return toResponse(new BukmiiException("Missing required parameter email.", 403));
		}

		final String firstName = user.getString("first_name");
		final String lastName = user.getString("last_name");
		final String email = user.getString("email");

		final RegistrationComponent comp = new RegistrationComponent();
		try {
			final UserFormBean bean = comp.signUpFB(email, firstName, lastName);
			return okResponse(201, null, bean);
		} catch (final BukmiiException e) {
			return toResponse(e);
		}
	}

}
