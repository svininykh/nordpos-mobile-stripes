package com.nordpos.mobile.stripes.dao;

import com.nordpos.mobile.stripes.model.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.persist.Persist;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class CustomerPersist extends BaseJDBCPersist {

    private Persist persist;

    public CustomerPersist() {
        try {
            persist = new Persist(getConnection());
        } catch (Exception ex) {
            Logger.getLogger(ApplicationPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer findCustomer(String id){
        return persist.read(Customer.class, "SELECT * FROM CUSTOMERS WHERE ID = ?", id);
    }

    public List<Customer> findCustomers(){
        return persist.readList(Customer.class, "SELECT * FROM CUSTOMERS");
    }
}
