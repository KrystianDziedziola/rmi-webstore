package edu.kystek.pwir.view;

import edu.kystek.pwir.model.AccountType;
import edu.kystek.pwir.model.rmi.LoginInformation;

import java.io.IOException;
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

}
