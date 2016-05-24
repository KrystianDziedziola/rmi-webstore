package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.Client;
import edu.kystek.pwir.view.client.LoginWindow;

import java.rmi.RemoteException;

public class ClientController {

    private Client client = new Client();

    private LoginWindow loginWindow = new LoginWindow();

    public void start() {
        try {
            client.start();
        } catch (RemoteException e) {
            loginWindow.showConnectionError();
            client.stop();
        }

        loginWindow.display();
    }
}
