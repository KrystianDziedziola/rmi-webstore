package edu.kystek.pwir.model.rmi;

import edu.kystek.pwir.controller.Shop;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Order;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.menu.customer.ProductProperty;
import edu.kystek.pwir.model.rmi.exception.Connection;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

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

    public ArrayList<Product> getProductsList() throws RemoteException {
        return shop.getProductsList();
    }

    public void stop() {
        System.exit(1);
    }

    public void addProduct(String name, String producer, int price, int quantity) throws RemoteException{
        shop.addProduct(name, producer, price, quantity);
    }

    public void removeProduct(int id) throws RemoteException {
        shop.removeProduct(id);
    }

    public void buyProduct(int id, int quantity, String login) throws RemoteException {
        shop.buyProduct(id, quantity, login);
    }

    public ArrayList<Order> getOrders() throws RemoteException{
        return shop.getOrders();
    }

    public ArrayList<Product> findProduct(String value, ProductProperty property) {
        ArrayList<Product> products = new ArrayList<>();
        switch (property) {
            case ID:
                products = findByID(value);
                break;
            case NAME:
                products = findByName(value);
                break;
            case PRODUCER:
                products = findByProducer(value);
                break;
        }
        return products;
    }

    private ArrayList<Product> findByID(String value) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        try {
            ArrayList<Product> allProducts = shop.getProductsList();

            for(Product product : allProducts) {
                if (product.getId() == Integer.parseInt(value)) {
                    foundProducts.add(product);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return foundProducts;
    }

    private ArrayList<Product> findByName(String value) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        try {
            ArrayList<Product> allProducts = shop.getProductsList();

            for(Product product : allProducts) {
                if (product.getName().equals(value)) {
                    foundProducts.add(product);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return foundProducts;
    }

    private ArrayList<Product> findByProducer(String value) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        try {
            ArrayList<Product> allProducts = shop.getProductsList();

            for(Product product : allProducts) {
                if (product.getProducer().equals(value)) {
                    foundProducts.add(product);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return foundProducts;
    }
}
