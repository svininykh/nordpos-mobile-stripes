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
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class ProductActionBean extends BaseActionBean {

    private static final String VIEW = "/WEB-INF/jsp/product_view.jsp";
    private ProductPersist productDao;
    private ProductCategoryPersist productCategoryDao;
    private String productId;

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public void setProductId(String id) {
        productId = id;
    }

    public Product getProduct() {
        productDao = new ProductPersist(getServletContext());
        return productDao.findProduct(productId);
    }
    
    public ProductCategory getProductCategory() {
        productCategoryDao = new ProductCategoryPersist(getServletContext());
        return productCategoryDao.findProductCategory(getProduct().getCategory());
    }    
}
