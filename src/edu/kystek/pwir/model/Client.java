package edu.kystek.pwir.model;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public void start() {
        try {
            Registry registry = LocateRegistry.getRegistry(Connection.SERVER_ADDRESS);
            Shop shop = (Shop) registry.lookup("Shop");
            System.out.println(shop.welcome());
        } catch (Exception e) {
            System.err.print("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
