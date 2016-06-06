package edu.kystek.pwir.model;

import java.io.Serializable;

public class Order implements Serializable {

    private String login;
    private int productId;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;
    private String date;

    public Order(String login, int productId, String productName, int price, int quantity,
                 int totalPrice, String date) {
        this.login = login;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "login='" + login + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", date='" + date + '\'' +
                '}';
    }
}
