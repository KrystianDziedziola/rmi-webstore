package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.model.rmi.Client;
import edu.kystek.pwir.view.ConsoleView;

public class Exit extends MenuItem implements Command {

    public Exit() {
        super("Exit");
    }

    @Override
    public void execute(Client client) {
        ConsoleView view = new ConsoleView();
        view.printEmptyLine();
        view.printLine("Goodbye!");
        System.exit(0);
    }
}
