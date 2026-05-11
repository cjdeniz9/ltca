package com.pluralsight.animal.model;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public String getName() {
        return name;
    }
}
