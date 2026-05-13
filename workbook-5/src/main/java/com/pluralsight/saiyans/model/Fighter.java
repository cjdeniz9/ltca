package com.pluralsight.saiyans.model;

public class Fighter {
    private String name;
    private String type;
    private int powerLevel;
    private int health;

    public Fighter(String name, String type, int powerLevel, int health) {
        this.name = name;
        this.type = type;
        this.powerLevel = powerLevel;
        this.health = health;
    }

    public void attack() {
        System.out.println(name + " attacks with power level " + powerLevel + "!");
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage.");
        System.out.println("Health left: " + health);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getHealth() {
        return health;
    }
}