package edu.kystek.pwir.view;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.Product;
import edu.kystek.pwir.model.menu.customer.ProductProperty;
import edu.kystek.pwir.model.rmi.LoginInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public void print(String text) {
        System.out.print(text);
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printError(String text) {
        System.err.println(text);
    }

    public void printEmptyLine() {
        printLine("");
    }

    public LoginInformation getLoginInformation() {
        print("Enter login: ");
        String login = scanner.next();

        print("Enter password: ");
        String password = scanner.next();
        printEmptyLine();

        return new LoginInformation(login, password);
    }

    public void showPostLoginInformation(AccountType accountType) {
        String type = null;
        switch (accountType) {
            case ADMIN:
                type = "Admin";
                break;
            case CUSTOMER:
                type = "Customer";
                break;
        }

        printLine("You logged in successfully!");
        printLine(String.format("Your account type is '%s'", type));
    }

    public void waitForEnter() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getProductInformation() throws NumberFormatException {
        String name, producer;
        int price, quantity;
        printEmptyLine();
        printLine("Enter product information");
        printEmptyLine();

        print("Name: ");
        name = scanner.nextLine();

        print("Producer: ");
        producer = scanner.nextLine();

        print("Price: ");
        price = Integer.parseInt(scanner.nextLine());

        print("Quantity: ");
        quantity = Integer.parseInt(scanner.nextLine());

        return new Product(name, producer, price, quantity);
    }

    public int getProductToRemoveId() {
        printEmptyLine();
        print("Enter ID of product that you want to remove: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getProductToBuy() {
        printEmptyLine();
        print("Which product do you want to buy? (enter ID): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getQuantity() {
        printEmptyLine();
        print("How many?: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public ProductProperty getProductProperty() {
        try {
            printEmptyLine();
            printLine("Find by: ");
            printLine("1. ID");
            printLine("2. Name");
            printLine("3. Producer");
            int answer = Integer.parseInt(scanner.nextLine());
            switch (answer) {
                case 1:
                    return ProductProperty.ID;
                case 2:
                    return ProductProperty.NAME;
                case 3:
                    return ProductProperty.PRODUCER;
                default:
                    throw new IllegalArgumentException("Number out of range");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Enter a number");
        }
    }

    public void printProducts(ArrayList<Product> products) {
        for (Product product : products) {
            printLine(product.toString());
        }
    }

    public String getFindValue() {
        printEmptyLine();
        printLine("Enter value: ");
        return scanner.nextLine();
    }
}
