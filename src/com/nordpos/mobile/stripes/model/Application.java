/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.model;

import java.util.List;

/**
 *
 * @author svininykh-av
 */
public class Application {

    private String id;
    private String name;
    private String version;
    private List<Application> application;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List getApplication() {
        return application;
    }

    public void setGlossary(List<Application> application) {
        this.application = application;
    }
}
