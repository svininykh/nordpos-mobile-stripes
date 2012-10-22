package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.model.People;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.log4j.Logger;

//@UrlBinding("/stripes/action")
public class LoginActionBean extends BaseActionBean {

    private static final Logger log = Logger.getLogger(LoginActionBean.class);
    private static final String LOGIN = "/WEB-INF/jsp/menu.jsp";
    private static final String VIEW = "/WEB-INF/jsp/login.jsp";
    private People loginUser = new People();
    private PeoplePersist peopleDao;
    private String loginName = "";
    private String loginPassword = "";

    @DefaultHandler
    public Resolution login() {
        log.info("Loading database object for login.jsp.");
        peopleDao = new PeoplePersist(getServletContext());
        loginUser = peopleDao.findUser(loginName, loginPassword);
        return new ForwardResolution(LOGIN);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public People getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(People loginUser) {
        this.loginUser = loginUser;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
