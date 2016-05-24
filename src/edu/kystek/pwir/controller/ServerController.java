package edu.kystek.pwir.controller;

import edu.kystek.pwir.model.Server;

public class ServerController {

    private Server server = new Server();

    public void start() {
        server.start();
    }
}
