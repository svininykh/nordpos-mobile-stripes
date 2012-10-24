package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.model.People;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

public class UserListActionBean extends BaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/user_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/user_view.jsp";
    private PeoplePersist peopleDao;
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
}
