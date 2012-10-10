
package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Application;
import com.nordpos.mobile.stripes.util.ConnectionInstance;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ApplicationPersist {

    private Persist persist;

    private static ApplicationPersist instance;

    public static ApplicationPersist getInstance() {
        if (instance == null) {
            instance = new ApplicationPersist();
        }

        return instance;
    }

    public Application readApplication() {
        persist = new Persist(ConnectionInstance.getConIsntance());
        Application app = persist.read(Application.class, "SELECT * FROM APPLICATIONS");
        return app;
    }
}
