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
import com.nordpos.mobile.stripes.util.ImageUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HttpCache;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;

public class ProductCategoryActionBean extends BaseActionBean {

    private static final String CATEGORIES_LIST = "/WEB-INF/jsp/productcategory_list.jsp";
    private ProductPersist productDao;
    private ProductCategoryPersist productCategoryDao;
    private String categoryId;

    @DefaultHandler
    @DontValidate
    @HttpCache(allow = false)
    public Resolution display() throws IOException {
        ProductCategory selectCategory = new ProductCategory();
        for(ProductCategory category : getProductCategories()) {
            if(category.getId().equals(categoryId)){
                selectCategory = category;
            }
        }
        return new StreamingResolution("image/jpeg",
                new ByteArrayInputStream(ImageUtils.createImageThumbnail(selectCategory.getImage(), 115)));
    }

    public Resolution list() {
        return new ForwardResolution(CATEGORIES_LIST);
    }

    public void setCategoryId(String categoryId){
        this.categoryId = categoryId;
    }

    public List<ProductCategory> getProductCategories() {
        productCategoryDao = new ProductCategoryPersist(getServletContext());

        List<ProductCategory> lProductCategories = productCategoryDao.findProductCategories();
        for (ProductCategory productCategory : lProductCategories) {
            productCategory.setCountProducts(getCountProductByCategory(productCategory.getId()));
        }
        return lProductCategories;
    }

    private Integer getCountProductByCategory(String productCategoryId) {
        productDao = new ProductPersist(getServletContext());
        return productDao.countProductByCategory(productCategoryId);
    }
}
