package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.Client;
import edu.kystek.pwir.view.ConsoleView;

import java.rmi.RemoteException;

public class ShowProducts extends MenuItem implements Command {

    public ShowProducts() {
        super("Show all products");
    }

    @Override
    public void execute(Client client) throws RemoteException {
        ConsoleView view = new ConsoleView();
        view.printEmptyLine();

        for (Product product : client.getProductsList()) {
            view.printLine(product.toString());
        }
    }
}
