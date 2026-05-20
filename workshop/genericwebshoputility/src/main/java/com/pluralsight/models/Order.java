package com.pluralsight.models;

public class Order implements Identifiable {

    private int id;
    private String productName;
    private int quantity;

    public Order(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Product: " + productName + ", Quantity: " +
                quantity;
    }

}