/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author svininykh-av
 */
public class ApplicationDAO {

    private static final Logger log = Logger.getLogger(ApplicationDAO.class);
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String database = "jdbc:mysql://localhost:3306/nordpos-db?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
    private static ApplicationDAO instance;

    public static ApplicationDAO getInstance() {
        if (instance == null) {
            instance = new ApplicationDAO();
        }

        return instance;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver).newInstance();

            Properties props = new Properties();
            props.put("user", "openbravo");
            props.put("password", "openbravo");

            connection = DriverManager.getConnection(database, props);
        } catch (Exception ex) {
            log.error("Error connecting to database: " + database, ex);
            throw new RuntimeException("Database " + database + " is not available.", ex);
        }

        return connection;
    }

    public List findApplicationVersions() {
        List applicationList = new ArrayList();

        Connection conn = getConnection();
        Statement s = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM APPLICATIONS ORDER BY NAME, VERSION");

            log.debug("Results of select * from app.glossary query:");
            while (rs.next()) {

                log.debug("  " + rs.getString("ID") + " " + rs.getString("VERSION") + " " + rs.getString("NAME"));
                Application application = new Application();
                application.setName(rs.getString("NAME"));
                application.setVersion(rs.getString("VERSION"));
                application.setId(rs.getString("ID"));
                applicationList.add(application);
            }
        } catch (Exception ex) {
            log.error("Really bad database error.", ex);
        } finally {
            try {
                rs.close();
                s.close();
//                conn.commit();
                conn.close();
            } catch (SQLException e) {
                log.error("More really bad database errors.", e);
            }
        }
        return applicationList;
    }
}
