package edu.kystek.pwir.model.menu;

import edu.kystek.pwir.view.ConsoleView;

public class MenuItem {

    private String name;

    protected ConsoleView view = new ConsoleView();

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
