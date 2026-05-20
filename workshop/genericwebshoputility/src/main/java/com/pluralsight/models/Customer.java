package com.pluralsight.models;

public class Customer implements Identifiable {

    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
    }

}
