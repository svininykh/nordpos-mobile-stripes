package com.nordpos.mobile.stripes.action;

import javax.servlet.ServletContext;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public abstract class BaseActionBean implements ActionBean {

    private ActionBeanContext actionBeanContext;

    @Override
    public ActionBeanContext getContext() {
        return actionBeanContext;
    }

    @Override
    public void setContext(ActionBeanContext actionBeanContext) {
        this.actionBeanContext = actionBeanContext;
    }

    public ServletContext getServletContext() {
        return getContext().getServletContext();
    }
}
