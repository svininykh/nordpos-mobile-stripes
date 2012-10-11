package com.nordpos.mobile.stripes.model;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class People {

    private String id;
    private String name;
    private String apppasword;
    private String card;
    private String role;
    private Boolean visible;
    private Byte[] image;

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

    public String getAppPassword() {
        return apppasword;
    }

    public void setAppPassword(String apppasword) {
        this.apppasword = apppasword;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
