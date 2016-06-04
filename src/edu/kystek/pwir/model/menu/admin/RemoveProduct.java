package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;

public class RemoveProduct extends MenuItem implements Command {

    public RemoveProduct() {
        super("Remove product");
    }

    @Override
    public void execute(Client client) throws RemoteException {
        int id = view.getProductToRemoveId();
        try {
            client.removeProduct(id);
            view.printEmptyLine();
            view.printLine("Product deleted successfully");
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }
}
