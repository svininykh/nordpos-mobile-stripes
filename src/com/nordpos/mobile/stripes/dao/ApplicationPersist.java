package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ApplicationPersist extends BaseJDBCPersist {

    public ApplicationPersist(ServletContext servletContext) {
        try {
            persist = new Persist(getConnection(servletContext));
        } catch (Exception ex) {
            Logger.getLogger(ApplicationPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Application readApplication() {
        Application app = persist.read(Application.class,
                "SELECT * FROM APPLICATIONS");
        return app;
    }
}
