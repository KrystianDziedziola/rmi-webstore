package edu.kystek.pwir.model.menu.customer;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;

public class BuyProduct extends MenuItem implements Command {

    public BuyProduct() {
        super("Buy product");
    }

    @Override
    public void execute() {
        System.out.println("Buy product");
    }
}
