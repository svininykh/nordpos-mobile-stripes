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
package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.ProductCategoryPersist;
import com.nordpos.mobile.stripes.dao.ProductPersist;
import com.nordpos.mobile.stripes.model.Product;
import com.nordpos.mobile.stripes.model.ProductCategory;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class ProductCatalogActionBean extends BaseActionBean {

    private static final String CATEGORIES_LIST = "/WEB-INF/jsp/productcategory_list.jsp";
    private static final String PRODUCTS_LIST = "/WEB-INF/jsp/product_list.jsp";    
    private ProductCategoryPersist productCategoryDao;
    private ProductPersist productDao;
    private String productCategoryId;    

    @DefaultHandler
    public Resolution listCategories() {
        return new ForwardResolution(CATEGORIES_LIST);
    }
    
    public Resolution listProducts() {
        return new ForwardResolution(PRODUCTS_LIST);
    }    

    public List<ProductCategory> getProductCategories() {
        productCategoryDao = new ProductCategoryPersist(getServletContext());
        return productCategoryDao.findProductCategories();
    }
    
    public void setProductCategoryId(String id) {
        productCategoryId = id;
    }

    public List<Product> getProducts() {
        productDao = new ProductPersist(getServletContext());
        return productDao.findProductByCategory(productCategoryId);
    }    
}
