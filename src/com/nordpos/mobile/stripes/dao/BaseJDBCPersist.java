/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.util.PropertyUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author svininykh-av
 */
public abstract class BaseJDBCPersist {

    private PropertyUtils properties;

    public BaseJDBCPersist() {
        properties = new PropertyUtils();
    }

    protected Connection getConnection() throws Exception {
        try {
            Class.forName(properties.getDriverName());
            return DriverManager.getConnection(properties.getUrl(), properties.getDBUser(), properties.getDBPassword());
        } catch (SQLException sqlex) {
        } catch (Exception ex) {
        }
        return null;
    }

}
