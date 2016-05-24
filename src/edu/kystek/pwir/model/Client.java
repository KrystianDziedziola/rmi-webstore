package edu.kystek.pwir.model;

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

}
