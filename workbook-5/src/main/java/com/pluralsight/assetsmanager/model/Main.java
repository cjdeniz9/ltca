package com.pluralsight.assetsmanager.model;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        Asset ranchHome = new House("Ranch Home", "2020-01-15", 250000.00, "123 Main St", 1, 2000, 8000);
        assets.add(ranchHome);

        Asset colonialHome = new House("Colonial", "2018-06-30", 180000.00, "456 Oak Ave", 3, 1500, 5000);
        assets.add(colonialHome);

        Asset sedan = new Vehicle("Sedan", "2021-03-10", 25000.00, "Toyota Camry", 2021, 15000);
        assets.add(sedan);

        Asset truck = new Vehicle("Truck", "2019-08-22", 35000.00, "Ford F-150", 2019, 85000);
        assets.add(truck);

        System.out.println();
        System.out.println("         ASSET PORTFOLIO           ");
        System.out.println();

        for (Asset asset : assets) {
            if (asset instanceof House house) {
                System.out.println("--- HOUSE -------------------------");
                System.out.println("Description  : " + house.getDescription());
                System.out.println("Date Acquired: " + house.getDateAcquired());
                System.out.println("Address      : " + house.getAddress());
                System.out.println("Original Cost: $" + house.getOriginalCost());
                System.out.println("Current Value: $" + house.getValue());
            } else if (asset instanceof Vehicle vehicle) {
                System.out.println("--- VEHICLE -----------------------");
                System.out.println("Description  : " + vehicle.getDescription());
                System.out.println("Date Acquired: " + vehicle.getDateAcquired());
                System.out.println("Year         : " + vehicle.getYear());
                System.out.println("Make & Model : " + vehicle.getMakeModel());
                System.out.println("Original Cost: $" + vehicle.getOriginalCost());
                System.out.println("Current Value: $" + vehicle.getValue());
            }

            System.out.println();
        }

    }
}
