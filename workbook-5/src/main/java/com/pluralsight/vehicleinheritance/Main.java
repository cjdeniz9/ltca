package com.pluralsight.vehicleinheritance;

import com.pluralsight.vehicleinheritance.model.*;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setColor("white");
        car.setFuelCapacity(12);

        Hovercraft hovercraft = new Hovercraft();
        hovercraft.setColor("chrome");
        hovercraft.setFuelCapacity(98);

        Moped moped = new Moped();
        moped.setColor("teal");
        moped.setFuelCapacity(8);

        SemiTruck semiTruck = new SemiTruck();
        semiTruck.setColor("brown");

        car.displayVehicle(VehicleType.CAR.getDisplayName());
        hovercraft.displayVehicle(VehicleType.HOVERCRAFT.getDisplayName());
        moped.displayVehicle(VehicleType.MOPED.getDisplayName());
        semiTruck.displayVehicle(VehicleType.SEMITRUCK.getDisplayName());

    }
}
