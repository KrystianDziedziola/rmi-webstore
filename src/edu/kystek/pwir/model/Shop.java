package edu.kystek.pwir.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface Shop extends Remote {
    String welcome() throws RemoteException;
}
