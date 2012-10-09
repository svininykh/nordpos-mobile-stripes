/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.action;

/**
 *
 * @author svininykh-av
 */
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;

@UrlBinding("/stripes/action")
public class ApplicationActionBean implements ActionBean {

    private static final Logger log = Logger.getLogger(ApplicationActionBean.class);
    private List results = new ArrayList();
    private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext actionBeanContext) {
        this.context = actionBeanContext;
    }

    @DefaultHandler
    public Resolution load() {
        log.info("loading");
        results.clear();
        if (results == null) {
            results = new ArrayList();
            results.add("ERROR LOADING APPLICATION.");
        }

        return new ForwardResolution("/login.jsp");
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }
}
