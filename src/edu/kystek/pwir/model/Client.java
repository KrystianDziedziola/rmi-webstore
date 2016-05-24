package edu.kystek.pwir.model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public void start() throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(Connection.SERVER_ADDRESS);
            Shop shop = (Shop) registry.lookup("Shop");
            System.out.println(shop.welcome());
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        System.exit(0);
    }
}
