package edu.kystek.pwir.model;

import edu.kystek.pwir.model.menu.customer.BuyProduct;
import edu.kystek.pwir.model.menu.customer.FindProduct;

public class Customer extends Account {

    public Customer() {
        addMenuItem(new BuyProduct());
        addMenuItem(new FindProduct());
    }
}
