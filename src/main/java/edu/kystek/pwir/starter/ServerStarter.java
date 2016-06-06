package edu.kystek.pwir.starter;

import edu.kystek.pwir.controller.ServerController;

public class ServerStarter {

    public static void main(String[] args) {
        new ServerStarter();
    }

    ServerStarter() {
        new ServerController().start();
    }
}
