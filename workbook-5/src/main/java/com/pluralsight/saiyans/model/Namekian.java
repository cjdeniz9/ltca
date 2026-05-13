package com.pluralsight.saiyans.model;

public class Namekian extends Fighter {

    public Namekian(String name, String type, int powerLevel, int health) {
        super(name, type, powerLevel, health);
    }

    public void regenerate() {
        setPowerLevel(getHealth() + 10);

        System.out.println(getName() + " regenerated health by 10!");
        System.out.println("New health: " + getPowerLevel());
    }
}
