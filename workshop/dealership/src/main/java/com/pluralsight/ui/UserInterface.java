package com.pluralsight.ui;

import com.pluralsight.data.ContractFileManager;
import com.pluralsight.data.DealershipFileManager;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import com.pluralsight.models.enums.VehicleType;
import com.pluralsight.ui.enums.MenuOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.ui.Helper.*;

public class UserInterface {
    private final Scanner scanner;
    private final DealershipFileManager dealershipFileManager;
    private final ContractFileManager contractFileManager;
    private Dealership dealership;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.dealershipFileManager = new DealershipFileManager();
        this.contractFileManager = new ContractFileManager();
    }

    public void display() {
        init();

        MenuOption selectedOption;
        do {
            displayHeader();
            displayMenu();
            int choice = readInt("Choose an option: ");
            selectedOption = MenuOption.fromCode(choice).orElse(null);
            handleMenuChoice(selectedOption);
        } while (selectedOption != MenuOption.QUIT);

        System.out.println("Goodbye!");
    }

    private void init() {
        this.dealership = dealershipFileManager.getDealership();
    }

    private void displayHeader() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Welcome to: " + dealership.getName());
        System.out.println(dealership.getAddress() + " | " + dealership.getPhone());
        System.out.println("=============================================");
    }

    private void displayMenu() {
        for (MenuOption option : MenuOption.values()) {
            System.out.printf("%-3d - %s%n", option.getCode(), option.getLabel());
        }
        System.out.println();
    }

    private void handleMenuChoice(MenuOption option) {
        if (option == null) {
            System.out.println("Invalid option. Please try again.");
            return;
        }

        switch (option) {
            case FIND_BY_PRICE -> processGetByPriceRequest();
            case FIND_BY_MAKE_MODEL -> processGetByMakeModelRequest();
            case FIND_BY_YEAR -> processGetByYearRequest();
            case FIND_BY_COLOR -> processGetByColorRequest();
            case FIND_BY_MILEAGE -> processGetByMileageRequest();
            case FIND_BY_TYPE -> processGetByVehicleTypeRequest();
            case LIST_ALL -> processAllVehiclesRequest();
            case ADD_VEHICLE -> processAddVehicleRequest();
            case REMOVE_VEHICLE -> processRemoveVehicleRequest();
            case SELL_LEASE_VEHICLE -> processSellLeaseVehicle();
            case QUIT -> { }
        }
    }

    private void processGetByPriceRequest() {
        double minPrice = readDouble("Minimum price: ");
        double maxPrice = readDouble("Maximum price: ");
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    private void processGetByMakeModelRequest() {
        String make = readString("Make, leave empty for any: ");
        String model = readString("Model, leave empty for any: ");
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        int minYear = readInt("Minimum year: ");
        int maxYear = readInt("Maximum year: ");
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    private void processGetByColorRequest() {
        String color = readString("Color: ");
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        int minMileage = readInt("Minimum mileage: ");
        int maxMileage = readInt("Maximum mileage: ");
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    private void processGetByVehicleTypeRequest() {
        VehicleType vehicleType = readVehicleType("Vehicle type (" + VehicleType.getAllowedValuesText() + "): ");
        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {
        System.out.println("Add a new vehicle");

        int vin = readPositiveInt("VIN: ");
        if (dealership.findVehicleByVin(vin).isPresent()) {
            System.out.println("A vehicle with this VIN already exists. Vehicle was not added.");
            return;
        }

        int year = readYear("Year: ");
        String make = readRequiredString("Make: ");
        String model = readRequiredString("Model: ");
        VehicleType vehicleType = readVehicleType("Vehicle type (" + VehicleType.getAllowedValuesText() + "): ");
        String color = readRequiredString("Color: ");
        int odometer = readPositiveInt("Odometer: ");
        double price = readPositiveDouble("Price: ");

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added and inventory saved.");
    }

    private void processRemoveVehicleRequest() {
        int vin = readPositiveInt("Enter VIN of vehicle to remove: ");

        dealership.findVehicleByVin(vin).ifPresentOrElse(vehicle -> {
            System.out.println("Vehicle found:");
            displayVehicles(List.of(vehicle));

            String confirmation = readString("Remove this vehicle? yes/no: ");
            if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                dealership.removeVehicleByVin(vin);
                dealershipFileManager.saveDealership(dealership);
                System.out.println("Vehicle removed and inventory saved.");
            } else {
                System.out.println("Remove cancelled.");
            }
        }, () -> System.out.println("No vehicle found with VIN " + vin + "."));
    }

    private void processSellLeaseVehicle() {
        int vin = readPositiveInt("Enter VIN of vehicle to sell/lease: ");

        dealership.findVehicleByVin(vin).ifPresentOrElse(
                this::handleSellLease,
                () -> System.out.println("No vehicle found with VIN " + vin + ".")
        );
    }

    private void handleSellLease(Vehicle vehicle) {
        System.out.println();
        System.out.println("Vehicle found:");
        displayVehicles(List.of(vehicle));

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String name = readRequiredString("Name: ");
        String email = readEmail("Email: ");

        String contractType = readString("Would you like to sell or lease the vehicle? (sell/lease): ");

        if (contractType.equalsIgnoreCase("sell") || contractType.equalsIgnoreCase("s")) {
            processSale(vehicle, date, name, email);
        } else if (contractType.equalsIgnoreCase("lease") || contractType.equalsIgnoreCase("l")) {
            processLease(vehicle, date, name, email);
        } else {
            System.out.println("Invalid option. Please enter 'sell' or 'lease'.");
        }
    }

    private void processSale(Vehicle vehicle, String date, String name, String email) {
        boolean isFinanced = readString("Would you like to finance? (yes/no): ").equalsIgnoreCase("yes");

        SalesContract salesContract = new SalesContract(date, name, email, vehicle, isFinanced);
        contractFileManager.saveContract(salesContract);

        System.out.println("Sale contract created successfully.");

        dealership.removeVehicleByVin(vehicle.getVin());
        dealershipFileManager.saveDealership(dealership);
    }

    private void processLease(Vehicle vehicle, String date, String name, String email) {
        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicle);
        contractFileManager.saveContract(leaseContract);

        System.out.println("Lease contract created successfully.");

        dealership.removeVehicleByVin(vehicle.getVin());
        dealershipFileManager.saveDealership(dealership);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            pause();
            return;
        }

        System.out.println();
        System.out.printf("%-8s %-6s %-12s %-15s %-8s %-10s %10s %17s%n",
                "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "ODOMETER", "PRICE");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        System.out.println("---------------------------------------------------------------------------------------------");

        if (vehicles.size() > 1) {
            System.out.println("Total vehicles: " + vehicles.size());
            pause();
        }
    }

    private void pause() {
        System.out.println();
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
}