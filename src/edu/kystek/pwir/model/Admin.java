package edu.kystek.pwir.model;

import edu.kystek.pwir.model.menu.admin.AddProduct;
import edu.kystek.pwir.model.menu.admin.RemoveProduct;

public class Admin extends Account {

    public Admin() {
        addMenuItem(new AddProduct());
        addMenuItem(new RemoveProduct());
    }
}
