package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.Client;
import edu.kystek.pwir.view.ConsoleView;

import java.rmi.RemoteException;

public class ClientController {

    private Client client = new Client();

    private ConsoleView view = new ConsoleView();

    public void start() {
        try {
            client.start();
            view.print(client.welcome());
        } catch (RemoteException e) {
            view.printError("Connection error");
            view.printError("Exception: " + e.toString());
        }
    }
}
