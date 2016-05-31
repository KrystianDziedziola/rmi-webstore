package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.rmi.Server;

import java.rmi.RemoteException;

public class ServerController {

    private Server server = new Server();

    public void start() {
        try {
            server.start();
        } catch (RemoteException e) {
            System.err.println("Shop server startup failed");
            System.err.println("Exception: " + e.toString());
            server.stop();
        }
        System.out.println("Shop server started successfully!");
    }
}
