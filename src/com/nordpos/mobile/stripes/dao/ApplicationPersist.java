package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ApplicationPersist extends BaseJDBCPersist {

    private Persist persist;

    public ApplicationPersist() {
        try {
            persist = new Persist(getConnection());
        } catch (Exception ex) {
            Logger.getLogger(ApplicationPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Application readApplication() {
        Application app = persist.read(Application.class, "SELECT * FROM APPLICATIONS");
        return app;
    }
}
