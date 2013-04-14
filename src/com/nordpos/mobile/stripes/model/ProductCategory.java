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
public class ProductCategory {

    private String id;
    private String name;
    private String parentid;
    private byte[] image;
    private Integer countProducts;

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

    public String getParentId() {
        return parentid;
    }

    public void setParentId(String parentid) {
        this.parentid = parentid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @NoColumn
    public Integer getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(Integer countProducts) {
        this.countProducts = countProducts;
    }
}
