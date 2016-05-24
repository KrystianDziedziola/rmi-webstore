package edu.kystek.pwir.model;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public void start() {
        try {
            Registry registry = LocateRegistry.createRegistry(Connection.DEFAULT_PORT);
            ShopImpl shop = new ShopImpl();
            registry.rebind("Shop", shop);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.print("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
