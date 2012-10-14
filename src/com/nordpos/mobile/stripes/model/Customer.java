package com.nordpos.mobile.stripes.model;

import java.util.Date;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class Customer {

    private String id;
    private String searchkey;
    private String taxid;
    private String name;
    private String taxcategory;
    private String card;
    private Double maxdebt;
    private String address;
    private String address2;
    private String postal;
    private String city;
    private String region;
    private String country;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String phone2;
    private String fax;
    private String notes;
    private Boolean visible;
    private Date curdate;
    private Double curdebt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchKey() {
        return searchkey;
    }

    public void setSearchKey(String searchkey) {
        this.searchkey = searchkey;
    }

    public String getTaxId() {
        return taxid;
    }

    public void setTaxId(String taxid) {
        this.taxid = taxid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCategory() {
        return taxcategory;
    }

    public void setTaxCategory(String taxcategory) {
        this.taxcategory = taxcategory;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Double getMaxDebt() {
        return maxdebt;
    }

    public void setMaxDebt(Double maxdebt) {
        this.maxdebt = maxdebt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Date getCurDate() {
        return curdate;
    }

    public void setCurDate(Date curdate) {
        this.curdate = curdate;
    }

    public Double getCurDebt() {
        return curdebt;
    }

    public void setCurDebt(Double curdebt) {
        this.curdebt = curdebt;
    }
}
