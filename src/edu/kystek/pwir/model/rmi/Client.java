package edu.kystek.pwir.model.rmi;

import edu.kystek.pwir.controller.Shop;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.exception.Connection;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.BlockingQueue;

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

    public BlockingQueue<Product> getProductsList() throws RemoteException {
        return shop.getProductsList();
    }

    public void stop() {
        System.exit(1);
    }

    public void addProduct(Product product) throws RemoteException {
        shop.addProduct(product);
    }

    public void removeProduct(int id) throws RemoteException {
        shop.removeProduct(id);
    }
}
