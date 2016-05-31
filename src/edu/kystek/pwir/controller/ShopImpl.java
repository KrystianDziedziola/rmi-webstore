package edu.kystek.pwir.controller;

import edu.kystek.pwir.controller.helper.TextFileToListConverter;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ShopImpl extends UnicastRemoteObject implements Shop {

    public ShopImpl() throws RemoteException {}

    @Override
    public String welcome() throws RemoteException {
        return "Welcome to the shop!";
    }

    @Override
    public AccountType login(LoginInformation loginInformation)
            throws RemoteException, WrongLoginInformationException {
        ArrayList<String> lines = new TextFileToListConverter().convert("accounts");

        for (String line : lines) {
            String lineParts[] = line.split(":");

            String login = lineParts[0];
            String password = lineParts[1];
            String accountType = lineParts[2];

            LoginInformation currentLineLogin = new LoginInformation(login, password);

            if (loginInformation.equals(currentLineLogin)) {
                switch(accountType) {
                    case "A":
                        return AccountType.ADMIN;
                    case "C":
                        return AccountType.CUSTOMER;
                }
            }
        }

        throw new WrongLoginInformationException();
    }

}
