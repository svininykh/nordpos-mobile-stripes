package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.CustomerPersist;
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.model.People;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.log4j.Logger;

//@UrlBinding("/stripes/action")
public class LoginActionBean extends BaseActionBean {

    private static final Logger log = Logger.getLogger(LoginActionBean.class);
    private static final String LOGIN = "/WEB-INF/jsp/administration.jsp";
    private static final String BACK = "/WEB-INF/jsp/welcome.jsp";
    private People loginUser = new People();
    private PeoplePersist peopleDao;
    private CustomerPersist customerDao;
    private String loginName = "";
    private String loginPassword = "";

    @DefaultHandler
    public Resolution login() {
        peopleDao = new PeoplePersist(getServletContext());
        loginUser = peopleDao.findUser(loginName, loginPassword);
        return new ForwardResolution(LOGIN);
    }

    public Resolution back() {
        return new ForwardResolution(BACK);
    }

    public People getLoginUser() {
        return loginUser;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getCountCustomers() {
        customerDao = new CustomerPersist(getServletContext());
        return customerDao.countCustomers();
    }

    public Integer getCountUsers() {
        peopleDao = new PeoplePersist(getServletContext());
        return peopleDao.countUsers();
    }
}
