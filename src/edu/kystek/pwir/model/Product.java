package edu.kystek.pwir.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String name;
    private String producer;
    private int price;
    private int quantity;

    public Product(int id, String name, String producer, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%d. %s, price: %d (producer: %s, quantity: %d)",
                id, name, price, producer, quantity);
    }
}
