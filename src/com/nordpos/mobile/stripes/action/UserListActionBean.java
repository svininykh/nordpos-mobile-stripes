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
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.dao.RolePersist;
import com.nordpos.mobile.stripes.model.People;
import com.nordpos.mobile.stripes.model.Role;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class UserListActionBean extends BaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/user_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/user_view.jsp";
    private PeoplePersist peopleDao;
    private RolePersist roleDao;
    private String userId;

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public void setUserId(String id) {
        userId = id;
    }

    public People getUser() {
        peopleDao = new PeoplePersist(getServletContext());
        return peopleDao.findUser(userId);
    }

    public List<People> getUsers() {
        peopleDao = new PeoplePersist(getServletContext());
        return peopleDao.findUsers();
    }

    public Integer getCountUsers() {
        return getUsers().size();
    }

    public List<Role> getRoles() {
        roleDao = new RolePersist(getServletContext());
        return roleDao.findRoles();
    }
}
