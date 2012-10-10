package com.nordpos.mobile.stripes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ConnectionInstance {

    static Connection con;

    public static Connection getConIsntance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nordpos-db", "openbravo", "openbravo");
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return con;
    }
}
