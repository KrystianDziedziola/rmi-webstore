package edu.kystek.pwir.view.client;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    private static final int WIDTH = 400, HEIGHT = 300;

    private Dimension windowSize = new Dimension(WIDTH, HEIGHT);

    public LoginWindow() {
        setTitle("Log into shop");
        setSize(windowSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void display() {
        setVisible(true);
    }

    public void showConnectionError() {
        JOptionPane.showMessageDialog(this, " Server not found.",
                "Connection error", JOptionPane.ERROR_MESSAGE);
    }
}
