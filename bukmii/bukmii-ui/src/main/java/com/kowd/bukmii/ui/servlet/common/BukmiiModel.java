package com.kowd.bukmii.ui.servlet.common;

import java.util.ArrayList;
import java.util.List;

import com.kowd.bukmii.formbeans.ResponseFormBean;
import com.kowd.bukmii.ui.constants.BukmiiWebConst;

/**
 * @author dchinagpis
 *
 */
public class BukmiiModel {

	/***/
	private final Request m_request;

	/***/
	private final Session m_session;

	/***/
	private final List<Object> m_out;

	/***/
	private boolean m_redirect;

	/***/
	private String m_redirectPath;

	/**
	 * @param request Request
	 * @param session Session
	 */
	public BukmiiModel(final Request request,
					   final Session session) {
		this.m_request = request;
		this.m_session = session;
		this.m_out = new ArrayList<>();
		this.m_redirectPath = null;
		this.m_redirect = false;
	}

	/**
	 * @return the redirectPath
	 */
	final String getRedirectPath() {
		return m_redirectPath;
	}

	/**
	 * @param redirectPath the redirectPath to set
	 */
	public void setRedirectPath(final String redirectPath) {
		this.m_redirectPath = redirectPath;
	}

	/**
	 * @return the m_redirect
	 */
	final boolean isRedirect() {
		return m_redirect;
	}

	/**
	 * @param redirect the m_redirect to set
	 */
	public void setRedirect(final boolean redirect) {
		this.m_redirect = redirect;
	}

	/**
	 * @return the request
	 */
	public Request getRequest() {
		return m_request;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return m_session;
	}

	/**
	 * @return the m_out
	 */
	final List<Object> getOut() {
		return m_out;
	}

	/**
	 * @param str String
	 */
	public void println(final String str) {
		m_out.add(str);
		m_out.add(BukmiiWebConst.NEW_LINE);
	}

	/**
	 * @param str String
	 */
	public void print(final String str) {
		m_out.add(str);
	}

	/**
	 * @param bean ResponseFormBean
	 */
	public void out(final ResponseFormBean bean) {
		m_out.add(bean);
	}
}
