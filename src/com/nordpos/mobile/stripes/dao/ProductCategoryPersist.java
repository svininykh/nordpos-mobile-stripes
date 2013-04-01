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
package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.ProductCategory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ProductCategoryPersist extends BaseJDBCPersist {

    public ProductCategoryPersist(ServletContext servletContext) {
        try {
            persist = new Persist(getConnection(servletContext));
        } catch (Exception ex) {
            Logger.getLogger(ProductCategoryPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductCategory findProductCategory(String id) {
        return persist.read(ProductCategory.class,
                "SELECT * FROM CATEGORIES WHERE ID = ?",
                id);
    }

    public List<ProductCategory> findProductCategories() {
        return persist.readList(ProductCategory.class,
                "SELECT * FROM CATEGORIES ORDER BY NAME");
    }

    public Integer countProductCategories() {
        return persist.read(Integer.class,
                "SELECT COUNT(ID) FROM CATEGORIES");
    }
}
