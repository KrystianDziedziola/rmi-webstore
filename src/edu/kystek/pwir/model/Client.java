package edu.kystek.pwir.model;

import edu.kystek.pwir.controller.Shop;
import edu.kystek.pwir.model.exception.Connection;
import edu.kystek.pwir.model.exception.WrongLoginInformationException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Shop shop;

    public void start() throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(Connection.SERVER_ADDRESS);
            shop = (Shop) registry.lookup("Shop");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public String welcome() throws RemoteException {
        return shop.welcome();
    }

    public AccountType login(LoginInformation loginInformation)
            throws RemoteException, WrongLoginInformationException {
        return shop.login(loginInformation);
    }
}
