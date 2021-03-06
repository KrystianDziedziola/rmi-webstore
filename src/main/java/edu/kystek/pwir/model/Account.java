package edu.kystek.pwir.model;

import edu.kystek.pwir.model.menu.Command;
import edu.kystek.pwir.model.menu.Exit;
import edu.kystek.pwir.model.menu.MenuConstants;
import edu.kystek.pwir.model.menu.ShowProducts;
import edu.kystek.pwir.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Account {

    private List<Command> options = new ArrayList<>();

    private ConsoleView view = new ConsoleView();
    private Scanner scanner = new Scanner(System.in);

    Account() {
        options.add(new ShowProducts());
        options.add(new Exit());
    }

    public void showMenu() {
        int itemNumber = MenuConstants.FIRST_ITEM_NUMBER;
        view.printEmptyLine();
        view.printLine("Menu:");
        for(Command option : options) {
            view.printLine(itemNumber + ". " + option);
            itemNumber++;
        }
    }

    public Command getAnswer() {
        int answer = scanner.nextInt();
        return options.get(answer - MenuConstants.DIFFERENCE_BETWEEN_INDEX_AND_ITEM_NUMBER);
    }

    void addMenuItem(Command item) {
        options.add(item);
    }
}
