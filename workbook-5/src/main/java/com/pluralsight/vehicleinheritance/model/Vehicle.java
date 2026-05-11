package com.pluralsight.vehicleinheritance.model;

public class Vehicle {

    private String color;
    private int numberOfPassengers;
    private int cargoCapacity;
    private int fuelCapacity;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void displayVehicle(String vehicleType) {
        System.out.println(
                "That " + getColor() + " " + vehicleType + " holds about " + getFuelCapacity() + " gallons."
        );
    }
}
