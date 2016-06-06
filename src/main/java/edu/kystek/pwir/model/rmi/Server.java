package edu.kystek.pwir.model.rmi;

import edu.kystek.pwir.controller.ShopImpl;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.exception.Connection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

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
