package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.LoginInformation;
import edu.kystek.pwir.model.exception.WrongLoginInformationException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shop extends Remote {

    String welcome() throws RemoteException;

    AccountType login(LoginInformation loginInformation) throws RemoteException, WrongLoginInformationException;
}
