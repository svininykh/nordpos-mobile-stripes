package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Role;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class RolePersist extends BaseJDBCPersist {

    public RolePersist(ServletContext servletContext) {
        try {
            persist = new Persist(getConnection(servletContext));
        } catch (Exception ex) {
            Logger.getLogger(ApplicationPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Role> findRoles() {
        return persist.readList(Role.class,
                "SELECT ID, NAME FROM ROLES ORDER BY NAME");
    }

}
