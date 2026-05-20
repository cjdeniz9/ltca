package com.pluralsight.models;

public class Product implements Identifiable {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: €" + price;
    }

}