package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;

public class AddProduct extends MenuItem implements Command {

    public AddProduct() {
        super("Add product");
    }

    @Override
    public void execute() {
        System.out.println("Add product");
    }
}
