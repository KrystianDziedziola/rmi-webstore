package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;

public class AddProduct extends MenuItem implements Command {

    public AddProduct() {
        super("Add product");
    }

    @Override
    public void execute(Client client, String login) {
        try {
            Product product = view.getProductInformation();
            client.addProduct(product.getName(), product.getProducer(), product.getPrice(), product.getQuantity());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            view.printError("This field should be a number");
        }
    }
}
