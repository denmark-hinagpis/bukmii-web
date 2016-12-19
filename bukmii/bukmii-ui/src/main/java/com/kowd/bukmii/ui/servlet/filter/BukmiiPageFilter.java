package com.kowd.bukmii.ui.servlet.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kowd.bukmii.ui.servlet.common.XSSRequestWrapper;
import com.kowd.bukmii.ui.text.Paths;

/**
 * @author dhinagpis
 */
@WebFilter(filterName = "BukmiiPageFilter",
urlPatterns = {"/*", "*.jsp"},
dispatcherTypes = {
	DispatcherType.REQUEST
})
public final class BukmiiPageFilter implements Filter {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(BukmiiPageFilter.class);

	/***/
	public BukmiiPageFilter() {
	}

	@Override
	public void init(final FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(final ServletRequest request,
						 final ServletResponse response,
						 final FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		final String contextPath = req.getContextPath();
		final String requestURI = req.getRequestURI();
		final String requestPath = requestURI.substring(contextPath.length(), requestURI.length());
		if (null == requestPath || "/".equals(requestPath)) {
			chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
			return;
		}
		final String path = requestPath.split("/")[1];
		if (requestPath.endsWith(".jsp")) {
			//Should not allow outside access of JSP and JSPF files
			LOGGER.debug("Invalid access: " + requestPath);
			req.getRequestDispatcher("/templates/404error.jsp").forward(request, response);
		} else if (!Paths.getAllPaths().contains("/" + path)) {
			req.getRequestDispatcher("/rest/search" + requestPath).forward(request, response);
		} else {
			chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
		}
	}

	@Override
	public void destroy() {
	}
}
