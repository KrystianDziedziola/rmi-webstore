package edu.kystek.pwir.controller;

import edu.kystek.pwir.controller.helper.TextFileToListConverter;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ShopImpl extends UnicastRemoteObject implements Shop {

    private BlockingQueue<Product> products = new LinkedBlockingDeque<>();

    public ShopImpl() throws RemoteException {
        products.add(new Product(1, "PC", "Asus", 3000, 20));
        products.add(new Product(2, "Printer", "HP", 250, 10));
    }

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

    @Override
    public BlockingQueue<Product> getProductsList() throws RemoteException {
        return products;
    }


}
