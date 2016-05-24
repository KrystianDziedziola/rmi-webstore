package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Client;
import edu.kystek.pwir.model.LoginInformation;
import edu.kystek.pwir.model.exception.WrongLoginInformationException;
import edu.kystek.pwir.view.ConsoleView;

import java.rmi.RemoteException;

public class ClientController {

    private Client client = new Client();

    private ConsoleView view = new ConsoleView();

    public void start() {
        connectToServer();
        askForLoginInformation();
    }

    private void connectToServer() {
        try {
            client.start();
            view.printLine(client.welcome());
            view.printEmptyLine();
        } catch (RemoteException e) {
            view.printError("Connection error");
            view.printError("Exception: " + e.toString());
        }
    }

    private void askForLoginInformation() {
        try {
            LoginInformation loginInformation = view.getLoginInformation();
            AccountType accountType = client.login(loginInformation);
            view.showPostLoginInformation(accountType);
        } catch (RemoteException e) {
            view.printError("Exception: " + e.toString());
            e.printStackTrace();
        } catch (WrongLoginInformationException e) {
            view.printError(e.getMessage());
        }


    }
}
