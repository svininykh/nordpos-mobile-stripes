package com.nordpos.mobile.stripes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public abstract class BaseJDBCPersist {

    public Persist persist;

    protected Connection getConnection(ServletContext servletContext) throws Exception {
        try {
            Class.forName(servletContext.getInitParameter("db.driver"));
            return DriverManager.getConnection(servletContext.getInitParameter("db.URL"),
                    servletContext.getInitParameter("db.user"),
                    servletContext.getInitParameter("db.password"));
        } catch (SQLException sqlex) {
        } catch (Exception ex) {
        }
        return null;
    }

    public boolean checkConnection() {
        return (persist.getConnection() != null);
    }
}
