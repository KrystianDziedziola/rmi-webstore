package edu.kystek.pwir.model;

import edu.kystek.pwir.model.menu.admin.AddProduct;

public class Admin extends Account {

    public Admin() {
        addMenuItem(new AddProduct());
    }
}
