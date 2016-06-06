package edu.kystek.pwir.model.menu.admin;

import edu.kystek.pwir.model.Order;
import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.MenuItem;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ShowOrders extends MenuItem implements Command {

    public ShowOrders() {
        super("Show orders");
    }

    @Override
    public void execute(Client client, String login) throws RemoteException {
        ArrayList<Order> orders = client.getOrders();

        if (orders.isEmpty()) {
            view.printLine("There are no orders");
        } else {
            view.printEmptyLine();
            view.printLine("Orders list:");
            for(Order order : orders) {
                view.printLine(order.toString());
            }
        }
    }
}
