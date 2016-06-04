package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.rmi.LoginInformation;
import edu.kystek.pwir.model.rmi.exception.WrongLoginInformationException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;

public interface Shop extends Remote {

    String welcome() throws RemoteException;

    AccountType login(LoginInformation loginInformation) throws RemoteException, WrongLoginInformationException;

    BlockingQueue<Product> getProductsList() throws RemoteException;

    void addProduct(Product product) throws RemoteException;

    void removeProduct(int id) throws RemoteException;
}
