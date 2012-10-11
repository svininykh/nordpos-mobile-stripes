package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.model.People;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;

//@UrlBinding("/stripes/action")
public class LoginActionBean implements ActionBean {

    private static final Logger log = Logger.getLogger(LoginActionBean.class);
    private People loginUser = new People();
    private ActionBeanContext context;
    private String loginName = "";
    private String loginPassword = "";

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext actionBeanContext) {
        this.context = actionBeanContext;
    }

    @DefaultHandler
    public Resolution login() {
        log.info("Loading database object for login.jsp.");
        loginUser = PeoplePersist.getInstance().findUser(loginName, loginPassword);

        return new ForwardResolution("/jsp/menu.jsp");
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
