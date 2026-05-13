package com.pluralsight.vehicleinheritance;

import com.pluralsight.vehicleinheritance.model.*;

// page 27

public class Main {

    public static void main(String[] args) {

        // Section 1-1
        // Simple Inheritance

//        Car car = new Car();
//        car.setColor("white");
//        car.setFuelCapacity(12);
//
//        Hovercraft hovercraft = new Hovercraft();
//        hovercraft.setColor("chrome");
//        hovercraft.setFuelCapacity(98);
//
//        Moped moped = new Moped();
//        moped.setColor("teal");
//        moped.setFuelCapacity(8);
//
//        SemiTruck semiTruck = new SemiTruck();
//        semiTruck.setColor("brown");
//
//        car.displayVehicle(VehicleType.CAR.getDisplayName());
//        hovercraft.displayVehicle(VehicleType.HOVERCRAFT.getDisplayName());
//        moped.displayVehicle(VehicleType.MOPED.getDisplayName());
//        semiTruck.displayVehicle(VehicleType.SEMITRUCK.getDisplayName());

        // Section 1-2
        // Working with Constructors

        Car car = new Car("red", 5, 24, 13);
        System.out.println("The " + car.getColor() + " car can seat up to " + car.getNumberOfPassengers() + " passengers, provides " + car.getCargoCapacity() + " square feet of cargo space and is equipped with a " + car.getFuelCapacity() + "-gallon fuel tank." );

    }
}
