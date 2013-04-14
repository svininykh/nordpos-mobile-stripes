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
import com.nordpos.mobile.stripes.dao.TaxCategoryPersist;
import com.nordpos.mobile.stripes.dao.TaxPersist;
import com.nordpos.mobile.stripes.logic.TaxesLogic;
import com.nordpos.mobile.stripes.model.Product;
import com.nordpos.mobile.stripes.model.ProductCategory;
import com.nordpos.mobile.stripes.model.TaxCategory;
import com.nordpos.mobile.stripes.util.ImageUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HttpCache;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;

public class ProductActionBean extends BaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/product_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/product_view.jsp";
    private static final String TICKET = "/WEB-INF/jsp/product_ticket.jsp";
    private ProductPersist productDao;
    private ProductCategoryPersist productCategoryDao;
    private TaxPersist taxDao;
    private TaxCategoryPersist taxCategoryDao;
    private Product product;
    private ProductCategory productCategory;
    private TaxesLogic taxesLogic;
    private String productId;
    private String productCategoryId;
    private String productRef;

    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public Resolution ticket() {
        return new ForwardResolution(TICKET);
    }

    @DefaultHandler
    @DontValidate
    @HttpCache(allow = false)
    public Resolution display() throws IOException {
        return new StreamingResolution("image/png",
                new ByteArrayInputStream(ImageUtils.createImageThumbnail(getProduct().getImage(), 140)));
    }

    @DontValidate
    @HttpCache(allow = false)
    public Resolution image() throws IOException {
        return new StreamingResolution("image/png",
                new ByteArrayInputStream(getProduct().getImage()));
    }

    public void setProductId(String id) {
        productId = id;
    }

    public void setProductCategoryId(String id) {
        productCategoryId = id;
    }

    public List<Product> getProducts() {
        productDao = new ProductPersist(getServletContext());
        List<Product> lProduct = productDao.findProductByCategory(productCategoryId);
        if (taxesLogic == null) {
            taxesLogic = getTaxesLogic();
        }
        for (Product eProduct : lProduct) {
            eProduct.setTaxRate(taxesLogic.getTaxRate(eProduct.getTaxCat(), new Date()));
        }
        return lProduct;
    }

    public void setProductRef(String ref) {
        productRef = ref;
    }

    public Product getProduct() {
        productDao = new ProductPersist(getServletContext());
        if (productRef == null) {
            product = productDao.findProductById(productId);
        } else {
            product = productDao.findProductByRef(productRef);
        }
        if (taxesLogic == null) {
            taxesLogic = getTaxesLogic();
        }
        product.setTaxRate(taxesLogic.getTaxRate(product.getTaxCat(), new Date()));
        return product;
    }

    public TaxesLogic getTaxesLogic() {
        taxDao = new TaxPersist(getServletContext());
        taxesLogic = new TaxesLogic(taxDao.findTaxes());
        return taxesLogic;
    }

    public TaxCategory getProductTaxCategory() {
        taxCategoryDao = new TaxCategoryPersist(getServletContext());
        return taxCategoryDao.findTaxCategory(getProduct().getTaxCat());
    }

    public ProductCategory getProductCategory() {
        productCategoryDao = new ProductCategoryPersist(getServletContext());
        if (product == null) {
            productCategory = productCategoryDao.findProductCategory(productCategoryId);
        } else {
            productCategory = productCategoryDao.findProductCategory(getProduct().getCategory());
        }
        return productCategory;
    }
}
