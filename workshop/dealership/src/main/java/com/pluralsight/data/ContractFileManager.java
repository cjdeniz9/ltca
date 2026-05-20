package com.pluralsight.data;

import com.pluralsight.models.*;
import com.pluralsight.models.enums.VehicleType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ContractFileManager {

    private static final Path CONTRACTS_PATH = Path.of("workshop", "dealership", "src", "main", "resources", "contracts.csv");
//    private static final String DELIMITER = "\\|";

    public void saveContract(Contract contract) {
        ensureFileExists();

        try (BufferedWriter writer = Files.newBufferedWriter(CONTRACTS_PATH,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            if (contract instanceof SalesContract salesContract) {
                writer.write(salesContract.toCsvLine());
            } else if (contract instanceof LeaseContract leaseContract) {
                writer.write(leaseContract.toCsvLine());
            } else {
                throw new IllegalStateException("Unknown contract type: " + contract.getClass().getName());
            }

            writer.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Could not save contract to file: " + CONTRACTS_PATH, e);
        }
    }

    private void ensureFileExists() {
        if (!Files.exists(CONTRACTS_PATH)) {
            throw new IllegalStateException("Contracts file not found at: " + CONTRACTS_PATH.toAbsolutePath());
        }
    }

//    public Dealership getDealership() {
//        ensureInventoryFileExists();
//
//        try (BufferedReader reader = Files.newBufferedReader(INVENTORY_PATH)) {
//            String dealershipLine = reader.readLine();
//
//            if (dealershipLine == null || dealershipLine.isBlank()) {
//                throw new IllegalStateException("The inventory file is empty.");
//            }
//
//            String[] dealershipFields = dealershipLine.split(DELIMITER);
//            if (dealershipFields.length != 3) {
//                throw new IllegalStateException("Invalid dealership line. Expected: name|address|phone");
//            }
//
//            Dealership dealership = new Dealership(dealershipFields[0], dealershipFields[1], dealershipFields[2]);
//
//            String vehicleLine;
//            while ((vehicleLine = reader.readLine()) != null) {
//                if (vehicleLine.isBlank()) {
//                    continue;
//                }
//                dealership.addVehicle(parseVehicle(vehicleLine));
//            }
//
//            return dealership;
//        } catch (IOException e) {
//            throw new IllegalStateException("Could not read inventory file: " + INVENTORY_PATH, e);
//        }
//    }
//
//    private Vehicle parseVehicle(String vehicleLine) {
//        String[] fields = vehicleLine.split(DELIMITER);
//        if (fields.length != 8) {
//            throw new IllegalStateException("Invalid vehicle line. Expected 8 fields: " + vehicleLine);
//        }
//
//        try {
//            int vin = Integer.parseInt(fields[0]);
//            int year = Integer.parseInt(fields[1]);
//            String make = fields[2];
//            String model = fields[3];
//            VehicleType vehicleType = VehicleType.fromString(fields[4])
//                    .orElseThrow(() -> new IllegalStateException("Invalid vehicle type in vehicle line: " + vehicleLine));
//            String color = fields[5];
//            int odometer = Integer.parseInt(fields[6]);
//            double price = Double.parseDouble(fields[7]);
//
//            return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
//        } catch (NumberFormatException e) {
//            throw new IllegalStateException("Invalid number in vehicle line: " + vehicleLine, e);
//        }
//    }
}