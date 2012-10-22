/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.util.PropertyUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 *
 * @author svininykh-av
 */
public abstract class BaseJDBCPersist {

    protected Connection getConnection(ServletContext servletContext) throws Exception {
        try {
            Class.forName(servletContext.getInitParameter("db.driver"));
            return DriverManager.getConnection(servletContext.getInitParameter("db.URL"), servletContext.getInitParameter("db.user"), servletContext.getInitParameter("db.password"));
        } catch (SQLException sqlex) {
        } catch (Exception ex) {
        }
        return null;
    }

}
