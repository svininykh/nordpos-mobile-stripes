package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Application;
import com.nordpos.mobile.stripes.model.People;
import com.nordpos.mobile.stripes.util.ConnectionInstance;
import com.nordpos.mobile.stripes.util.PasswordDecryptor;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class PeoplePersist {

    private Persist persist;
    private static PeoplePersist instance;

    public static PeoplePersist getInstance() {
        if (instance == null) {
            instance = new PeoplePersist();
        }

        return instance;
    }

    public People findUser(String login, String password) {
        persist = new Persist(ConnectionInstance.getConIsntance());
        String sqlStr = "SELECT * FROM PEOPLE WHERE NAME = ? AND APPPASSWORD ";
        People validUser;
        if (password.isEmpty()) {
            validUser = persist.read(People.class, sqlStr.concat("IS NULL"), login);
        } else {
            validUser = persist.read(People.class, sqlStr.concat("= ?"), login, PasswordDecryptor.hashString(password));
        }

        return validUser;
    }
}
