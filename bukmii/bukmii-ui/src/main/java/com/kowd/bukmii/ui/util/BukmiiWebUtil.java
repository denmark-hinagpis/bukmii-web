package com.kowd.bukmii.ui.util;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.kowd.bukmii.app.component.LoginComponent;
import com.kowd.bukmii.app.exception.BukmiiException;
import com.kowd.bukmii.ui.constants.BukmiiWebConst;

/**
 * @author dchinagpis
 *
 */
public final class BukmiiWebUtil {

	/***/
	private static final Logger LOGGER = LogManager.getLogger(BukmiiWebUtil.class);

	/***/
	private BukmiiWebUtil() {

	}

	/**
	 * @param request HttpServletRequest
	 * @return boolean
	 * @throws BukmiiException e
	 */
	public static boolean isAuthenticatedWeb(final HttpServletRequest request) throws BukmiiException {
		final HttpSession session = request.getSession();
		if (null != session) {
			final String userId = (String) session.getAttribute(BukmiiWebConst.ATTR_USER_USERID);
			if (null != userId) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param request HttpServletRequest
	 * @return boolean
	 * @throws BukmiiException e
	 */
	public static boolean isAuthenticatedBasic(final HttpServletRequest request) throws BukmiiException {
		if (null != request.getHeader("Authorization")) {
			final StringTokenizer st = new StringTokenizer(request.getHeader("Authorization"));
			if (st.hasMoreTokens()) {
				final String basic = st.nextToken();

				if (basic.equalsIgnoreCase("Basic")) {
					try {
						final String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
						final int p = credentials.indexOf(":");
						if (p != -1) {
							final String email = credentials.substring(0, p).trim();
							final String password = credentials.substring(p + 1).trim();
							final LoginComponent login = new LoginComponent();
							return login.authenticate(email, password);
						}
					} catch (final UnsupportedEncodingException e) {
						LOGGER.warn("Unknown encoding format.", e);
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param session HttpSession
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public static String getAttributeAsString(final HttpSession session, final String key, final String defaultVal) {
		if (null != session.getAttribute(key)) {
			return (String) session.getAttribute(key);
		}
		return defaultVal;
	}

	/**
	 * @param session HttpSession
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public static int getAttributeAsInt(final HttpSession session, final String key, final int defaultVal) {
		if (null != session.getAttribute(key)) {
			final String val = (String) session.getAttribute(key);
			try {
				return Integer.parseInt(val);
			} catch (final NumberFormatException e) {
				//
			}
		}
		return defaultVal;
	}

	/**
	 * @param request HttpServletRequest
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public static String getAttributeAsString(final HttpServletRequest request, final String key, final String defaultVal) {
		if (null != request.getAttribute(key)) {
			return (String) request.getAttribute(key);
		}
		return defaultVal;
	}

	/**
	 * @param request HttpServletRequest
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public static int getAttributeAsInt(final HttpServletRequest request, final String key, final int defaultVal) {
		if (null != request.getAttribute(key)) {
			final String val = (String) request.getAttribute(key);
			try {
				return Integer.parseInt(val);
			} catch (final NumberFormatException e) {
				//
			}
		}
		return defaultVal;
	}

	/**
	 * @param request HttpServletRequest
	 * @param key String
	 * @return JSONObject
	 */
	public static JSONObject getAttributeAsInt(final HttpServletRequest request, final String key) {
		if (null != request.getAttribute(key)) {
			final String val = (String) request.getAttribute(key);
			try {
				return new JSONObject(val);
			} catch (final JSONException e) {
			}
		}
		return null;
	}

	/**
	 * @param request HttpServletRequest
	 * @param key String
	 * @param defaultVal String
	 * @return String
	 */
	public static String getParameterAsString(final HttpServletRequest request, final String key, final String defaultVal) {
		if (null == request.getParameter(key)) {
			return request.getParameter(key);
		}
		return defaultVal;
	}

	/**
	 * @param request HttpServletRequest
	 * @param key String
	 * @param defaultVal int
	 * @return int
	 */
	public static int getParameterAsInt(final HttpServletRequest request, final String key, final int defaultVal) {
		if (null == request.getParameter(key)) {
			final String val = request.getParameter(key);
			try {
				return Integer.parseInt(val);
			} catch (final NumberFormatException e) {
			}
		}
		return defaultVal;
	}

}
