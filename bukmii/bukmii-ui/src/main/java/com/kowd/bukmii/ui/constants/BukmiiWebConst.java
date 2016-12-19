package com.kowd.bukmii.ui.constants;

/**
 * @author dchinagpis
 *
 */
public final class BukmiiWebConst {

	/***/
	private BukmiiWebConst() {
	}

	/**
	 * Pattern:.
	 * 	Path   - PATH_<PATH_NAME>
	 *  Mathod - METHOD_<PATH_NAME>_xxx
	 */

	//START: Attributes
	/***/
	public static final String ATTR_RESPONSE = "response";
	/***/

	public static final String ATTR_STATUS = "status";

	/***/
	public static final String ATTR_MESSAGE = "message";

	/***/
	public static final String ATTR_DATA = "data";


	/***/
	public static final String ATTR_REDIRECT_URL = "redirect_url";

	/***/
	public static final String ATTR_SEARCH_PATH = "search_url";

	/***/
	public static final String ATTR_LOGIN_ATTEMPT = "login_attempt";


	/***/
	public static final String ATTR_USER_USERID = "user_id";

	/***/
	public static final String ATTR_USER_EMAIL = "email";

	/***/
	public static final String ATTR_USER_USERNAME = "user_name";

	/***/
	public static final String ATTR_USER_PASSCODE = "passcode";

	/***/
	public static final String ATTR_USER_PASSWORD = "password";

	/***/
	public static final String ATTR_USER_FIRSTNAME = "first_name";

	/***/
	public static final String ATTR_USER_LASTNAME = "last_name";

	/***/
	public static final String ATTR_USER_PHONENUMBER = "phone_number";

	/***/
	public static final String ATTR_USER_IMAGE = "image";
	//END: Attributes

	//START: Method
	/***/
	public static final String METHOD_LOGON_LOGIN = "bukmii.login";

	/***/
	public static final String METHOD_LOGON_LOGOUT = "bukmii.logout";

	/***/
	public static final String METHOD_LOGON_SIGNUP = "bukmii.signup";

	/***/
	public static final String METHOD_LOGON_LOGIN_FB = "bukmii.login.fb";
	//END: Method

	// New Line for output response
	/***/
	public static final String NEW_LINE = "<new-line>";

}
