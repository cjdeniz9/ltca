package com.pluralsight.saiyans.model;

public class Saiyan extends Fighter {

    public Saiyan(String name, String type, int powerLevel, int health) {
        super(name, type, powerLevel, health);
    }

    public void transform() {
        int newPowerLevel = getPowerLevel() * 2;
        setPowerLevel(newPowerLevel);

        System.out.println(getName() + " transforms into Super Saiyan!");
        System.out.println("New power level: " + getPowerLevel());
    }
}