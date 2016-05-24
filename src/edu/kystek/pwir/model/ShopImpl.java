package edu.kystek.pwir.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class ShopImpl extends UnicastRemoteObject implements Shop {

    ShopImpl() throws RemoteException {}

    @Override
    public String welcome() throws RemoteException {
        return "Welcome to the shop!";
    }
}
