package edu.kystek.pwir.model.menu.customer;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;

public class BuyProduct extends MenuItem implements Command {

    public BuyProduct() {
        super("Buy product");
    }

    @Override
    public void execute(Client client, String login) {
        try {
            int id = view.getProductToBuy();
            int quantity = view.getQuantity();
            client.buyProduct(id, quantity, login);
            view.printEmptyLine();
            view.printLine("You've successfully bought this product");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }
}
