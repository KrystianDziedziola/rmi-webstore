package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.rmi.Client;

public class Exit extends MenuItem implements Command {

    public Exit() {
        super("Exit");
    }

    @Override
    public void execute(Client client, String login) {
        view.printEmptyLine();
        view.printLine("Goodbye!");
        System.exit(0);
    }
}
