package com.kowd.bukmii.ui.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kowd.bukmii.ui.text.Messages;


/**
 * @author dhinagpis
 */
public class MessageTag extends SimpleTagSupport {

	/***/
    private String m_key;

    @Override
	public final void doTag() throws JspException, IOException {
        getJspContext().getOut().print(Messages.getString(m_key));
    }

    /**
     * @param key String
     */
    public void setKey(final String key) {
        m_key = key;
    }

}
