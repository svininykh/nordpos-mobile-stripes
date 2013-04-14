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

import java.util.Date;
import net.sf.persist.annotations.NoColumn;
import net.sf.persist.annotations.NoTable;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
@NoTable
public class Tax {

    private String id;
    private String name;
    private Date validfrom;
    private String category;
    private String custcategory;
    private String parentid;
    private Double rate;
    private Boolean ratecascade;
    private Integer rateorder;

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

    public Date getValidFrom() {
        return validfrom;
    }

    public void setValidFrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustCategory() {
        return custcategory;
    }

    public void setCustCategory(String custcategory) {
        this.custcategory = custcategory;
    }

    public String getParentId() {
        return parentid;
    }

    public void setParentId(String parentid) {
        this.parentid = parentid;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getRateCascade() {
        return ratecascade;
    }

    public void setRateCascade(Boolean ratecascade) {
        this.ratecascade = ratecascade;
    }

    public Integer getRateOrder() {
        return rateorder;
    }

    @NoColumn
    public Integer getApplicationRateOrder() {
        return rateorder == null ? Integer.MAX_VALUE : rateorder.intValue();
    }

    public void setRateOrder(Integer rateorder) {
        this.rateorder = rateorder;
    }
}
