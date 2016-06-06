package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.Account;
import edu.kystek.pwir.model.rmi.Client;

import java.rmi.RemoteException;

public interface Command {
    void execute(Client client, String login) throws RemoteException;
}
