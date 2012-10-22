package com.nordpos.mobile.stripes.action;

import javax.servlet.ServletContext;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public abstract class BaseActionBean implements ActionBean {
    private ActionBeanContext actionBeanContext;

    public ActionBeanContext getContext() {
        return actionBeanContext;
    }
    public void setContext(ActionBeanContext actionBeanContext) {
        this.actionBeanContext = actionBeanContext;
    }

    public ServletContext getServletContext() {
        return getContext().getServletContext();
    }
}
