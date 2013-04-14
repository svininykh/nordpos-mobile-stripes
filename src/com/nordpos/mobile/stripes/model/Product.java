/**
 * Copyright (c) 2012-2013 Nord Trading Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.nordpos.mobile.stripes.model;

import net.sf.persist.annotations.NoColumn;
import net.sf.persist.annotations.NoTable;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
@NoTable
public class Product {

    private String id;
    private String reference;
    private String code;
    private String codetype;
    private String name;
    private Double pricebuy;
    private Double pricesell;
    private String category;
    private String taxcat;
    private String attributeset_id;
    private Double stockcost;
    private Double stockvolume;
    private byte[] image;
    private Boolean iscom;
    private Boolean isscale;
    private byte[] attributes;
    private Double taxrate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeType() {
        return codetype;
    }

    public void setCodeType(String codetype) {
        this.codetype = codetype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceBuy() {
        return pricebuy;
    }

    public void setPriceBuy(Double pricebuy) {
        this.pricebuy = pricebuy;
    }

    public Double getPriceSell() {
        return pricesell;
    }

    public void setPriceSell(Double pricesell) {
        this.pricesell = pricesell;
    }

    @NoColumn
    public Double getPriceSellTax() {
        return getPriceSell() + getTaxAmount();
    }

    @NoColumn
    public Double getTaxRate() {
        return taxrate;
    }

    @NoColumn
    public Double getTaxAmount() {
        return getPriceSell() * getTaxRate();
    }

    public void setTaxRate(Double taxrate) {
        this.taxrate = taxrate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTaxCat() {
        return taxcat;
    }

    public void setTaxCat(String taxcat) {
        this.taxcat = taxcat;
    }

    public String getAttributeSet_Id() {
        return attributeset_id;
    }

    public void setAttributeSet_Id(String attributeset_id) {
        this.attributeset_id = attributeset_id;
    }

    public Double getStockCost() {
        return stockcost;
    }

    public void setStockCost(Double stockcost) {
        this.stockcost = stockcost;
    }

    public Double getStockVolume() {
        return stockvolume;
    }

    public void setStockVolume(Double stockvolume) {
        this.stockvolume = stockvolume;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Boolean getIsCom() {
        return iscom;
    }

    public void setIsCom(Boolean iscom) {
        this.iscom = iscom;
    }

    public Boolean getIsScale() {
        return isscale;
    }

    public void setIsScale(Boolean isscale) {
        this.isscale = isscale;
    }

    public byte[] getAttributes() {
        return attributes;
    }

    public void setAttributes(byte[] attributes) {
        this.attributes = attributes;
    }
}
