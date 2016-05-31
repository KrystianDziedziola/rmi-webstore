package edu.kystek.pwir.model.menu.customer;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

public class BuyProduct extends MenuItem implements Command {

    public BuyProduct() {
        super("Buy product");
    }

    @Override
    public void execute(Client client) {
        System.out.println("Buy product");
    }
}
