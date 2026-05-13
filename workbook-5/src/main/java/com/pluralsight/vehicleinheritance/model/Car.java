package com.pluralsight.vehicleinheritance.model;

public class Car extends Vehicle {

    public Car(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
        System.out.println("Trace -- in Car(color, numberOfPassengers, cargoCapacity, fuelCapacity) w/ color, numberOfPassengers, cargoCapacity and fuelCapacity");

    }
}
