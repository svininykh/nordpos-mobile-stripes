/**
 * Copyright (c) 2012 Nord Trading Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.log4j.Logger;

public class LoginActionBean extends BaseActionBean {

    private static final Logger log = Logger.getLogger(LoginActionBean.class);
    private static final String LOGIN = "/WEB-INF/jsp/administration.jsp";
    private static final String VIEW = "/WEB-INF/jsp/welcome.jsp";
    private People loginUser = new People();
    private PeoplePersist peopleDao;
    private CustomerPersist customerDao;
    private String loginName;
    private String loginPassword;

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(LOGIN);
    }

    public Resolution login() {
        peopleDao = new PeoplePersist(getServletContext());
        loginUser = peopleDao.findUser(loginName, loginPassword);
        if (loginUser != null) {
            return new ForwardResolution(LOGIN);
        } else {
            return new RedirectResolution(VIEW);
        }
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
