package com.kowd.bukmii.ui.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kowd.bukmii.ui.constants.BukmiiWebConst;

/**
 * @author dhinagpis
 *
 */
public class UserTag extends SimpleTagSupport {

    @Override
	public final void doTag() throws JspException, IOException {
    	final String username = (String) getJspContext().getAttribute(BukmiiWebConst.ATTR_USER_USERNAME, PageContext.SESSION_SCOPE);
		if (username != null) {
			 getJspContext().getOut().print(username);
		}
    }

}
