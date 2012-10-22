package com.nordpos.mobile.stripes.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author jaroslawwozniak
 */
@Deprecated
public class PropertyUtils {

    private Properties m_propsconfig;
    private File configFile;
    private final String APP_ID = "nordpos";

    @Deprecated
    public PropertyUtils() {
        init(getDefaultConfig());
    }

    @Deprecated
    private void init(File configfile) {
        this.configFile = configfile;
        load();
    }

    @Deprecated
    private File getDefaultConfig() {
        return new File(new File(System.getProperty("user.home")), APP_ID + ".properties");
    }

    @Deprecated
    private void load() {
        // Cargo las propiedades
        try {
            InputStream in = new FileInputStream(configFile);
            if (in != null) {
                m_propsconfig = new Properties();
                m_propsconfig.load(in);
                in.close();
            }
        } catch (IOException e) {
        }
    }

    @Deprecated
    public String getProperty(String sKey) {
        return m_propsconfig.getProperty(sKey);
    }

    @Deprecated
    public String getDriverName() {
        return m_propsconfig.getProperty("db.driver");
    }

    @Deprecated
    public String getUrl() {
        return m_propsconfig.getProperty("db.URL");
    }

    @Deprecated
    public String getDBUser() {
        return m_propsconfig.getProperty("db.user");
    }

    @Deprecated
    public String getDBPassword() {
        CryptUtils cypher = new CryptUtils("cypherkey" + getDBUser());

        return cypher.decrypt(m_propsconfig.getProperty("db.password").substring(6));
    }
}
