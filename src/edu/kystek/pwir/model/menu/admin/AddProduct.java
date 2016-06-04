package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;
import edu.kystek.pwir.view.ConsoleView;

import java.rmi.RemoteException;

public class AddProduct extends MenuItem implements Command {

    public AddProduct() {
        super("Add product");
    }

    @Override
    public void execute(Client client) {
        try {
            Product product = view.getProductInformation();
            client.addProduct(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
