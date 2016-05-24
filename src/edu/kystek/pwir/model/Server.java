package edu.kystek.pwir.model;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public void start() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Connection.DEFAULT_PORT);
        ShopImpl shop = new ShopImpl();
        registry.rebind("Shop", shop);
    }

    public void stop() {
        System.exit(0);
    }
}
