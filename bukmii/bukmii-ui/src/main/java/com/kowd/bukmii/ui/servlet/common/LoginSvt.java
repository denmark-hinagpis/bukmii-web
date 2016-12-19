package com.kowd.bukmii.ui.servlet.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kowd.bukmii.app.component.LoginComponent;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.formbeans.ResponseFormBean;
import com.kowd.bukmii.formbeans.UserFormBean;
import com.kowd.bukmii.ui.constants.BukmiiWebConst;
import com.kowd.bukmii.ui.util.BukmiiWebUtil;

/**
 * @author dchinagpis
 *
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public final class LoginSvt extends AbstractBaseSvt {

	private static final long serialVersionUID = 1L;

	/***/
	private final LoginComponent m_component;

	/***/
	public LoginSvt() {
		super(LoginSvt.class);
		m_component = new LoginComponent();
	}

	@Override
	protected boolean byPassLogin(final String method) throws BukmiiException {
		return true;
	}

	@Override
	protected void doWork(final HttpServletRequest request,
						  final HttpServletResponse response) throws BukmiiException, ServletException, IOException {
		final String method = request.getMethod();
		switch (method) {
		case "GET":
			processGet(request, response);
			break;
		case "POST":
			processPost(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws BukmiiException e
	 * @throws ServletException e
	 * @throws IOException e
	 */
	private void processPost(final HttpServletRequest request,
							 final HttpServletResponse response) throws BukmiiException, ServletException, IOException {
		final String email = BukmiiWebUtil.getAttributeAsString(request, BukmiiWebConst.ATTR_USER_EMAIL, "");
		final String password = BukmiiWebUtil.getAttributeAsString(request, BukmiiWebConst.ATTR_USER_PASSWORD, "");
		final ResponseFormBean bean = m_component.login(email, password);
		if (201 == bean.getStatus()) {
			final HttpSession session = request.getSession(true);
			final UserFormBean userBean = (UserFormBean) bean.getData();
			session.setAttribute(BukmiiWebConst.ATTR_USER_USERID, userBean.getId());
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			final int attempt = BukmiiWebUtil.getAttributeAsInt(request, BukmiiWebConst.ATTR_LOGIN_ATTEMPT, 0);
			if (attempt >= 3) {
				request.setAttribute(BukmiiWebConst.ATTR_LOGIN_ATTEMPT, attempt + 1);
				request.getRequestDispatcher("/templates/relogin.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/templates/errorlogin.jsp");
			}
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws BukmiiException e
	 * @throws ServletException e
	 * @throws IOException e
	 */
	private void processGet(final HttpServletRequest request,
							final HttpServletResponse response) throws BukmiiException, ServletException, IOException {
		final int attempt = BukmiiWebUtil.getAttributeAsInt(request, BukmiiWebConst.ATTR_LOGIN_ATTEMPT, 0);
		if (attempt == 1) {
			request.setAttribute(BukmiiWebConst.ATTR_LOGIN_ATTEMPT, attempt + 1);
			request.getRequestDispatcher("/templates/relogin.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/templates/login.jsp").forward(request, response);
		}
	}

}
