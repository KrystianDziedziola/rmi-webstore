package edu.kystek.pwir.controller;

import edu.kystek.pwir.controller.helper.TextFileToListConverter;
import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Order;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShopImpl extends UnicastRemoteObject implements Shop {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public ShopImpl() throws RemoteException {
        addProduct("CD", "Verbatim", 2, 50);
        addProduct("PC", "HP", 2000, 10);
        addProduct("Radio", "Sony", 300, 35);
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
    public ArrayList<Product> getProductsList() throws RemoteException {
        return products;
    }

    @Override
    public void addProduct(String name,String  producer, int price, int quantity) {
        products.add(new Product(name, producer, price, quantity));
    }

    @Override
    public void removeProduct(int id) throws RemoteException {
        Product product = findProductById(id);
        products.remove(product);
    }

    @Override
    public void buyProduct(int id, int quantity, String login) throws RemoteException, IllegalArgumentException {
        Product product = findProductById(id);
        product.remove(quantity);
        orders.add(new Order(login, product.getId(), product.getName(), product.getPrice(),
                    quantity, product.getPrice() * quantity, getCurrentDate()));
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public ArrayList<Order> getOrders() throws RemoteException {
        return orders;
    }

    private Product findProductById(int id) throws IllegalArgumentException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException(String.format("Product with ID: '%d' not found", id));
    }

}
