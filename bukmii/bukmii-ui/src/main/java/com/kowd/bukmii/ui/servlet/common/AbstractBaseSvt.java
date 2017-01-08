package com.kowd.bukmii.ui.servlet.common;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.ui.text.Paths;
import com.kowd.bukmii.ui.util.BukmiiWebUtil;

/**
 * @author dchinagpis
 *
 */
public abstract class AbstractBaseSvt extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	/***/
	private final Logger m_logger;

	/***/
	private ServletSettings m_settings;

	/**
	 * @param clazz Class< ? extends AbstractBaseSvt>
	 */
	protected AbstractBaseSvt(final Class< ? extends AbstractBaseSvt> clazz) {
		super();
		m_logger = LogManager.getLogger(clazz);
	}

	@Override
	public final void init(final ServletConfig config) throws ServletException {
		super.init(config);
		m_settings = (ServletSettings) config.getServletContext().getAttribute("settings");
	}

	/**
	 * @return ServletSettings
	 */
	protected ServletSettings getSettings() {
		return m_settings;
	}

	@Override
	protected final void doDelete(final HttpServletRequest request,
						 	final HttpServletResponse response) throws ServletException, IOException {
		superDoWork(request, response);
	}

	@Override
	protected final void doGet(final HttpServletRequest request,
						 	   final HttpServletResponse response) throws ServletException, IOException {
		superDoWork(request, response);
	}

	@Override
	protected final void doPut(final HttpServletRequest request,
						 	   final HttpServletResponse response) throws ServletException, IOException {
		superDoWork(request, response);
	}

	@Override
	protected final void doPost(final HttpServletRequest request,
								final HttpServletResponse response) throws ServletException, IOException {
		superDoWork(request, response);
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException e
	 * @throws IOException e
	 */
	private void superDoWork(final HttpServletRequest request,
							 final HttpServletResponse response) throws ServletException, IOException {
		// check if the user has been authenticated
		if (byPassLogin(request.getMethod()) || BukmiiWebUtil.isAuthenticatedWeb(request)) {
			response.setCharacterEncoding(m_settings.getOutputEncoding());
			doWork(request, response);
		} else {
			final String redirectPath = Paths.getString("Login.Servlet.Path");
			request.getRequestDispatcher(redirectPath).forward(request, response);
		}
	}

	/**
	 * @param method String
	 * @return boolean
	 * @throws BukmiiException e
	 */
	protected abstract boolean byPassLogin(String method);

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws BukmiiException e
	 * @throws ServletException e
	 * @throws IOException e
	 */
	protected abstract void doWork(HttpServletRequest request,
								   HttpServletResponse response) throws ServletException, IOException;

	/**
	 * @return Logger
	 */
	protected Logger getLogger() {
		return m_logger;
	}

}
