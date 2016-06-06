package edu.kystek.pwir.starter;

import edu.kystek.pwir.controller.ClientController;

public class ClientStarter {

    public static void main(String[] args) {
        new ClientStarter();
    }

    ClientStarter() {
        new ClientController().start();
    }
}
