package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Order;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public interface Shop extends Remote {

    String welcome() throws RemoteException;

    AccountType login(LoginInformation loginInformation) throws RemoteException, WrongLoginInformationException;

    ArrayList<Product> getProductsList() throws RemoteException;

    void addProduct(String name,String  producer, int price, int quantity) throws RemoteException;

    void removeProduct(int id) throws RemoteException;

    void buyProduct(int id, int quantity, String login) throws RemoteException, IllegalArgumentException;

    ArrayList<Order> getOrders() throws RemoteException;
}
