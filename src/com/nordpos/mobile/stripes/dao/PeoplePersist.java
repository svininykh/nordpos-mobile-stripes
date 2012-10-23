package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Customer;
import com.nordpos.mobile.stripes.model.People;
import com.nordpos.mobile.stripes.util.PasswordUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class PeoplePersist extends BaseJDBCPersist {

    private Persist persist;

    public PeoplePersist(ServletContext servletContext) {
        try {
            persist = new Persist(getConnection(servletContext));
        } catch (Exception ex) {
            Logger.getLogger(ApplicationPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public People findUser(String login, String password) {
        People validUser;
        if (password.isEmpty()) {
            validUser = persist.read(People.class,
                    "SELECT * FROM PEOPLE WHERE NAME = ? AND APPPASSWORD IS NULL",
                    login);
        } else {
            validUser = persist.read(People.class,
                    "SELECT * FROM PEOPLE WHERE NAME = ? AND APPPASSWORD = ?",
                    login,
                    PasswordUtils.hashString(password));
        }

        return validUser;
    }

    public People findUser(String id) {
        return persist.read(People.class,
                "SELECT * FROM PEOPLE WHERE ID = ?",
                id);
    }

    public List<People> findUsers() {
        return persist.readList(People.class,
                "SELECT * FROM PEOPLE ORDER BY NAME");
    }

    public Integer countUsers() {
        return persist.read(Integer.class,
                "SELECT COUNT(ID) FROM PEOPLE");
    }
}
