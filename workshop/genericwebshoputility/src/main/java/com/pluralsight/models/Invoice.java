package com.pluralsight.models;

public class Invoice implements Identifiable {

    private int id;
    private String customerName;
    private double amount;

    public Invoice(int id, String customerName, double amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + id + ", Customer Name: " + customerName + ", Amount: €" + amount;
    }
}
