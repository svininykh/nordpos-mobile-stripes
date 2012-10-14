package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.util.ConnectionInstance;
import com.nordpos.mobile.stripes.model.Customer;
import java.util.List;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class CustomerPersist {

    private Persist persist;
    private static CustomerPersist instance;

    public static CustomerPersist getInstance() {
        if (instance == null) {
            instance = new CustomerPersist();
        }

        return instance;
    }

    public Customer findCustomer(String id){
        persist = new Persist(ConnectionInstance.getConIsntance());
        return persist.read(Customer.class, "SELECT * FROM CUSTOMERS WHERE ID = ?", id);
    }

    public List<Customer> findCustomers(){
        persist = new Persist(ConnectionInstance.getConIsntance());
        return persist.readList(Customer.class, "SELECT * FROM CUSTOMERS");
    }
}
