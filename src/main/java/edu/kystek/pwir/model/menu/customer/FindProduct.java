package edu.kystek.pwir.model.menu.customer;

import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FindProduct extends MenuItem implements Command {

    public FindProduct() {
        super("Find product");
    }

    @Override
    public void execute(Client client, String login) throws RemoteException {
        try {
            ProductProperty property = view.getProductProperty();
            String value = view.getFindValue();
            ArrayList<Product> products = client.findProduct(value, property);
            if (products.isEmpty()) {
                view.printError("Products not found");
            } else {
                view.printEmptyLine();
                view.printProducts(products);
            }
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }

    }
}
