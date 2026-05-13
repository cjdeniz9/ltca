package com.pluralsight.saiyans.service;

import com.pluralsight.saiyans.model.Fighter;

import java.util.ArrayList;

public class FighterManager {

    ScreenManager screenManager = new ScreenManager();

    private ArrayList<Fighter> team;

    public FighterManager() {
        this.team = new ArrayList<>();
    }

    public void addFighterToTeam(String fighterType) {
        System.out.print("Enter " + fighterType + " name: ");
        String name = screenManager.getStringInput();

        System.out.print("Enter power level: ");
        int powerLevel = screenManager.getIntInput();

        System.out.print("Enter health: ");
        int health = screenManager.getIntInput();

        Fighter fighter = new Fighter(name, fighterType, powerLevel, health);

        team.add(fighter);

        System.out.println();

        System.out.println(name + " has been added to your team!");
    }

    public void displayTeam() {
        for (Fighter fighter : team) {
            System.out.println();
            System.out.println("--- " + fighter.getName() + " ---");
            System.out.println("Type  : " + fighter.getType());
            System.out.println("Power : " + fighter.getPowerLevel());
            System.out.println("Health: " + fighter.getHealth());
            System.out.println();
        }
    }

}
