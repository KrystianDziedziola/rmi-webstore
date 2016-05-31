package edu.kystek.pwir.model.menu;

public class MenuItem {

    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
