package com.kowd.bukmii.ui.controller;

import javax.servlet.annotation.WebServlet;

import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.ui.servlet.common.AbstractWebController;
import com.kowd.bukmii.ui.servlet.common.BukmiiModel;

/**
 * @author dchinagpis
 *
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public final class HomeController extends AbstractWebController {

	private static final long serialVersionUID = 1L;

	/***/
	public HomeController() {
		super(HomeController.class);
	}

	@Override
	protected void processGet(final BukmiiModel model) throws BukmiiException {
		//TODO: add all reference parameter to request
		model.setRedirect(false);
		model.setRedirectPath("/templates/home.jsp");
	}

	@Override
	protected void processPost(final BukmiiModel model) throws BukmiiException {
	}

	@Override
	protected boolean byPassLogin(final String method) {
		return true;
	}

}
