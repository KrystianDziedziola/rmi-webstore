package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ShowProducts extends MenuItem implements Command {

    public ShowProducts() {
        super("Show all products");
    }

    @Override
    public void execute(Client client, String login) throws RemoteException {
        view.printEmptyLine();

        ArrayList<Product> products = client.getProductsList();
        if (products.isEmpty()) {
            view.printLine("There are no products available");
        } else {
            for (Product product : client.getProductsList()) {
                view.printLine(product.toString());
            }
        }
    }
}
