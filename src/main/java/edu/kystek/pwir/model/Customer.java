package edu.kystek.pwir.model;

import edu.kystek.pwir.model.menu.customer.BuyProduct;

public class Customer extends Account {

    public Customer() {
        addMenuItem(new BuyProduct());
    }
}
