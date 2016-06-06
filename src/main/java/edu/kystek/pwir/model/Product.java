package edu.kystek.pwir.model;

import java.io.Serializable;

public class Product implements Serializable {

    private static int numberOfProducts;

    private int id;
    private String name;
    private String producer;
    private int price;
    private int quantity;

    public Product(String name, String producer, int price, int quantity) {
        numberOfProducts++;
        id = numberOfProducts;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.quantity = quantity;
    }

    public void remove(int quantity) {
        if(quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            throw new IllegalArgumentException("Not enough products in shop");
        }
    }

    public static int getNumberOfProducts() {
        return numberOfProducts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public int getPrice() {
        return price;
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
