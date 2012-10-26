/**
 *  Copyright (c) 2012 Nord Trading Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.nordpos.mobile.stripes.action;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
import com.nordpos.mobile.stripes.dao.CustomerPersist;
import com.nordpos.mobile.stripes.model.Customer;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class CustomerListActionBean extends BaseActionBean {

    private static final String LIST = "/WEB-INF/jsp/customer_list.jsp";
    private static final String VIEW = "/WEB-INF/jsp/customer_view.jsp";
    private CustomerPersist customerDao;
    private String customerId;

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }

    public Resolution view() {
        return new ForwardResolution(VIEW);
    }

    public void setCustomerId(String id) {
        customerId = id;
    }

    public Customer getCustomer() {
        customerDao = new CustomerPersist(getServletContext());
        return customerDao.findCustomer(customerId);
    }

    public List<Customer> getCustomers() {
        customerDao = new CustomerPersist(getServletContext());
        return customerDao.findCustomers();
    }

    public Integer getCountCustomers() {
        return getCustomers().size();
    }
}
