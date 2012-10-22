package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.ApplicationPersist;
import com.nordpos.mobile.stripes.model.Application;
import javax.servlet.ServletContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;

@UrlBinding("/stripes/action")
public class WelcomeActionBean extends BaseActionBean {

    private static final Logger log = Logger.getLogger(WelcomeActionBean.class);
    private static String VIEW = "/WEB-INF/jsp/welcome.jsp";
    private Application application = new Application();
//    private ServletContext servletContext = getServletContext();
    private ApplicationPersist applicationDao;

    @DefaultHandler
    public Resolution load() {
        log.info("Loading database object for welcome.jsp.");
        applicationDao  = new ApplicationPersist(getServletContext());
        application = applicationDao.readApplication();
        return new ForwardResolution(VIEW);
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
