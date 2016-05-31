package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

public class AddProduct extends MenuItem implements Command {

    public AddProduct() {
        super("Add product");
    }

    @Override
    public void execute(Client client) {
        System.out.println("Add product");
    }
}
