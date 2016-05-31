package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;

public interface Command {
    void execute(Client client) throws RemoteException;
}
