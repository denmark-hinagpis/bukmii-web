package com.kowd.bukmii.ui.rest.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.ui.util.BukmiiWebUtil;

/**
 * @author dchinagpis
 *
 */
@Provider
public class BukmiiAuthFilter implements ContainerRequestFilter {

	/***/
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
														  .entity("You cannot access this resource")
														  .build();

	/***/
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
														  .entity("Access blocked for all users !!")
														  .build();

	/***/
	private static final Response INTERNAL_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
														  .entity("Access blocked for all users !!")
														  .build();

	/***/
	@Context
    private ResourceInfo m_resourceInfo;

	/***/
	@Context
    private HttpServletRequest m_request;

	/**
	 * @param requestContext
	 * @throws IOException
	 */
	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {
		final Method method = m_resourceInfo.getResourceMethod();

		if (!method.isAnnotationPresent(PermitAll.class)) {
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(ACCESS_FORBIDDEN);
	            return;
			}

			try {
				if (!BukmiiWebUtil.isAuthenticatedBasic(m_request) &&
						!BukmiiWebUtil.isAuthenticatedWeb(m_request)) {
					requestContext.abortWith(ACCESS_DENIED);
				    return;
				}
			} catch (final BukmiiException e) {
				requestContext.abortWith(INTERNAL_ERROR);
			    return;
			}

			//TODO: Add Role for security
//			if (method.isAnnotationPresent(RolesAllowed.class)) {
//				final RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
//                final Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
//			}
		}
	}

}
