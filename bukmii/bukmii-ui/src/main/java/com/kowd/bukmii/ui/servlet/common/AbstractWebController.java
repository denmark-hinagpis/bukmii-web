package com.kowd.bukmii.ui.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.app.util.BukmiiUtil;
import com.kowd.bukmii.ui.constants.BukmiiWebConst;

/**
 * @author dchinagpis
 *
 */
public abstract class AbstractWebController extends AbstractBaseSvt {

	private static final long serialVersionUID = 1L;

	/**
	 * @param clazz Class< ? extends AbstractWebController>
	 */
	protected AbstractWebController(final Class< ? extends AbstractWebController> clazz) {
        super(clazz);
	}

	@Override
	protected final void doWork(final HttpServletRequest request,
								final HttpServletResponse response) throws ServletException, IOException {
		final String method = request.getMethod();
		if (hasMethod(method)) {
			final BukmiiModel model = new BukmiiModel(createRequestModel(request),
													  createSessionModel(request.getSession(false)));
			try {
				process(method, model);
			} catch (final BukmiiException e) {
				request.getSession().setAttribute(BukmiiWebConst.ATTR_STATUS, e.getStatus());
				request.getSession().setAttribute(BukmiiWebConst.ATTR_MESSAGE, e.getMessage());
				response.sendRedirect(request.getContextPath() + "/403error.jsp");
				return;
			}

			processResponse(request, response, model);
		} else {
			response.sendRedirect(request.getContextPath() + "/404error.jsp");
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param model BukmiiModel
	 * @throws ServletException e
	 * @throws IOException e
	 */
	private void processResponse(final HttpServletRequest request,
								 final HttpServletResponse response,
								 final BukmiiModel model) throws ServletException, IOException {
		if (model.getOut().size() > 0) {
			response.setContentType(request.getContentType());
			final PrintWriter out = response.getWriter();
			if (model.getOut().size() == 1) {
				out.write(new JSONObject(model.getOut().get(0)).toString());
			} else {
				for (final Object obj : model.getOut()) {
					final String str = (String) obj;
					if (BukmiiWebConst.NEW_LINE.equals(str)) {
						out.println();
					} else {
						out.print(str);
					}
				}
			}
			out.flush();
		} else {
			setRequest(request, model.getRequest().get());
			setSession(request, model.getSession().get());
			if (!BukmiiUtil.isNullOrEmpty(model.getRedirectPath())) {
				if (model.isRedirect()) {
					response.sendRedirect(request.getContextPath() + model.getRedirectPath());
				} else {
					request.getRequestDispatcher(model.getRedirectPath()).forward(request, response);
				}
			}
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param properties Properties
	 */
	private void setSession(final HttpServletRequest request,
							final Properties properties) {
		if (properties.size() > 0) {
			final HttpSession session = request.getSession();
			final Enumeration< ? > keys = properties.propertyNames();
			while (keys.hasMoreElements()) {
				final String key = (String) keys.nextElement();
				final Object val = request.getAttribute(key);
				session.setAttribute(key, val);
			}
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param properties Properties
	 */
	private void setRequest(final HttpServletRequest request,
							final Properties properties) {
		final Enumeration< ? > keys = properties.propertyNames();
		while (keys.hasMoreElements()) {
			final String key = (String) keys.nextElement();
			final Object val = request.getAttribute(key);
			request.setAttribute(key, val);
		}
	}

	/**
	 * @param method String
	 * @param model BukmiiModel
	 * @throws BukmiiException e
	 */
	private void process(final String method, final BukmiiModel model) throws BukmiiException {
		switch (method) {
		case "GET":
			processGet(model);
			break;
		case "POST":
			processPost(model);
			break;
		case "DELETE":
			processDelete(model);
			break;
		case "PUT":
			processPut(model);
			break;

		default:
			break;
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @return Request
	 */
	private Request createRequestModel(final HttpServletRequest request) {

		final Properties param = new Properties();
		param.putAll(request.getParameterMap());

		final Enumeration<String> keys = request.getAttributeNames();
		final Properties attr = new Properties();
		while (keys.hasMoreElements()) {
			final String key = keys.nextElement();
			final Object val = request.getAttribute(key);
			attr.put(key, val);
		}
		return new Request(attr, param);
	}

	/**
	 * @param session HttpSession
	 * @return Session
	 */
	private Session createSessionModel(final HttpSession session) {
		final Properties props = new Properties();
		if (null != session) {
			final Enumeration<String> keys = session.getAttributeNames();
			final Properties attr = new Properties();
			while (keys.hasMoreElements()) {
				final String key = keys.nextElement();
				final Object val = session.getAttribute(key);
				attr.put(key, val);
			}
		}
		return new Session(props);
	}

	/**
	 * @param method String
	 * @return boolean
	 */
	private boolean hasMethod(final String method) {
		if (Arrays.asList(supportMethod()).contains(method)) {
			return true;
		}
		return false;
	}

	/**
	 * Override this method if you want to add other Methods.
	 * Possible Methods: GET, PUT, DELETE, POST
	 * @return String[]
	 */
	protected String[] supportMethod() {
		return new String[] {"GET", "POST"};
	}

	/**
	 * @param model BukmiiModel
	 * @throws BukmiiException e
	 */
	protected abstract void processGet(BukmiiModel model) throws BukmiiException;

	/**
	 * @param model BukmiiModel
	 * @throws BukmiiException e
	 */
	protected abstract void processPost(BukmiiModel model) throws BukmiiException;

	/**
	 * Override this method to handle PUT Method.
	 * @param model BukmiiModel
	 * @throws BukmiiException e
	 */
	protected void processPut(final BukmiiModel model) throws BukmiiException {
		throw new BukmiiException("Method not availale.", 404);
	}

	/**
	 * Override this method to handle DELETE Method.
	 * @param model BukmiiModel
	 * @throws BukmiiException e
	 */
	protected void processDelete(final BukmiiModel model) throws BukmiiException {
		throw new BukmiiException("Method not availale.", 404);
	}
}
