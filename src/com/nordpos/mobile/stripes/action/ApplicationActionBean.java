package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.ApplicationPersist;
import com.nordpos.mobile.stripes.dao.BaseJDBCPersist;
import com.nordpos.mobile.stripes.model.Application;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;

@UrlBinding("/stripes/action")
public class ApplicationActionBean extends BaseActionBean {

    private static final Logger log = Logger.getLogger(ApplicationActionBean.class);
    private static String VIEW = "/WEB-INF/jsp/welcome.jsp";
    private static String INFO = "/WEB-INF/jsp/info.jsp";
    private Application application = new Application();
    private ApplicationPersist applicationDao;
    private boolean connectionStatus = true;

    @DefaultHandler
    public Resolution load() {
        log.info("Loading database object for welcome.jsp.");
        applicationDao = new ApplicationPersist(getServletContext());
        if (applicationDao.checkConnection()) {
            application = applicationDao.readApplication();
            return new ForwardResolution(VIEW);
        } else {
            connectionStatus = false;
            return new ForwardResolution(INFO);
        }
    }

    public Application getApplication() {
        return application;
    }

    public boolean getConnectionStatus() {
        return connectionStatus;
    }

    public Resolution info() {

        return new ForwardResolution(INFO);
    }

    public String getCountry() {
        return getContext().getLocale().getDisplayCountry();
    }

    public String getLanguage() {
        return getContext().getLocale().getDisplayLanguage();
    }

    public String getServerInfo() {
        return getServletContext().getServerInfo();
    }

    public String getDataBaseDriver() {
        return getServletContext().getInitParameter("db.driver");
    }

    public String getDataBaseURL() {
        return getServletContext().getInitParameter("db.URL");
    }
}
