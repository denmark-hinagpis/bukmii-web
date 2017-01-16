package com.kowd.bukmii.ui.services;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kowd.bukmii.app.component.LoginComponent;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.ui.rest.common.AbstractBaseResource;

/**
 * @author dchinagpis
 *
 */
@Path("/login")
public class LoginResource extends AbstractBaseResource {

	/***/
	public LoginResource() {
		super(LoginResource.class);
	}

	/**
	 *
	 * @param email String
	 * @param ecryptedPassword String
	 * @return Response
	 */
	@POST
	@PermitAll
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam(value = "email") final String email,
			   			  @FormParam(value = "password") final String ecryptedPassword) {
		if (null == email || email.isEmpty()) {
			return toResponse(new BukmiiException("Missing required parameter email.", 403));
		}
		if (null == ecryptedPassword || ecryptedPassword.isEmpty()) {
			return toResponse(new BukmiiException("Missing required parameter password.", 403));
		}

		final LoginComponent comp = new LoginComponent();
		try {
			final UserFormBean bean = comp.login(email, ecryptedPassword);
			return okResponse(201, null, bean);
		} catch (final BukmiiException e) {
			return toResponse(e);
		}
	}

}
