package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.ApplicationPersist;
import com.nordpos.mobile.stripes.model.Application;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;

@UrlBinding("/stripes/action")
public class WelcomeActionBean implements ActionBean {

    private static final Logger log = Logger.getLogger(WelcomeActionBean.class);
    private Application application = new Application();
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
        application = ApplicationPersist.getInstance().readApplication();

        return new ForwardResolution("/WEB-INF/jsp/welcome.jsp");
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
