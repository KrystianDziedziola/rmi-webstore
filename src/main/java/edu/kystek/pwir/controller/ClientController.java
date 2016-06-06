package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.Account;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Admin;
import edu.kystek.pwir.model.Customer;
import edu.kystek.pwir.model.rmi.Client;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;
import edu.kystek.pwir.view.ConsoleView;

import java.rmi.RemoteException;

public class ClientController {

    private Client client = new Client();
    private Account account;
    private String login;

    private ConsoleView view = new ConsoleView();

    public void start() {
        connectToServer();
        askForLoginInformation();
        showMenu();
    }

    private void showMenu() {
        try {
            while(true) {
                account.showMenu();
                account.getAnswer().execute(client, login);
                view.printEmptyLine();
                view.print("Press enter to continue...");
                view.waitForEnter();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void connectToServer() {
        try {
            client.start();
            view.printLine(client.welcome());
            view.printEmptyLine();
        } catch (RemoteException e) {
            view.printError("Connection error");
            view.printError("Exception: " + e.toString());
            client.stop();
        }
    }

    private void askForLoginInformation() {
        try {
            LoginInformation loginInformation = view.getLoginInformation();
            AccountType accountType = client.login(loginInformation);
            view.showPostLoginInformation(accountType);
            account = getAccount(accountType);
            login = loginInformation.getLogin();
        } catch (RemoteException e) {
            view.printError("Exception: " + e.toString());
            e.printStackTrace();
        } catch (WrongLoginInformationException e) {
            view.printError(e.getMessage());
            client.stop();
        }


    }

    private Account getAccount(AccountType accountType) {
        switch (accountType) {
            case ADMIN:
                return new Admin();
            case CUSTOMER:
                return new Customer();
            default:
                throw new IllegalArgumentException("Wrong account type");
        }
    }
}
