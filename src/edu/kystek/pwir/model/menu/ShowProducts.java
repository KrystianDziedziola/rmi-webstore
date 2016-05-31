package edu.kystek.pwir.model.menu;

public class ShowProducts extends MenuItem implements Command {

    public ShowProducts() {
        super("Show all products");
    }

    @Override
    public void execute() {
        System.out.println("products");
    }
}
