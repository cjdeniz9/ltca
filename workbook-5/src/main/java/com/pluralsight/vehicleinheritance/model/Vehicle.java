package com.pluralsight.vehicleinheritance.model;

public class Vehicle {

    private String color;
    private int numberOfPassengers;
    private int cargoCapacity;
    private int fuelCapacity;

    public Vehicle(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        System.out.println("Trace -- in Vehicle(color, numberOfPassengers, cargoCapacity, fuelCapacity) w/ color, numberOfPassengers, cargoCapacity and fuelCapacity");
        this.color = color;
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void displayVehicle(String vehicleType) {
        System.out.println(
                "That " + getColor() + " " + vehicleType + " holds about " + getFuelCapacity() + " gallons."
        );
    }
}
