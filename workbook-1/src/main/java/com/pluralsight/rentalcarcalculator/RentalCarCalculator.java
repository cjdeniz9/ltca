package com.pluralsight.rentalcarcalculator;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! When do you want to pickup the rental?");
        System.out.print("> ");
        String pickupDate = scanner.nextLine();
        System.out.println("");

        System.out.println("How many days do you need the rental?");
        System.out.print("> ");
        int daysRented = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        System.out.println("Would you like to add on a electronic toll tag for $3.95/day? [yes/no]");
        System.out.print("> ");
        String electronicTollTag = scanner.nextLine();
        System.out.println("");

        System.out.println("Would you like to add on a GPS for $2.95/day? [yes/no]");
        System.out.print("> ");
        String gps = scanner.nextLine();
        System.out.println("");

        System.out.println("Would you like to add on roadside assistance for $3.95/day? [yes/no]");
        System.out.print("> ");
        String roadsideAssistance = scanner.nextLine();
        System.out.println("");

        System.out.println("How old are you?");
        System.out.print("> ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        double rentalCost = 29.99 * daysRented;
        double addOnCost = 0;
        String addedOn = "";

        if (electronicTollTag.equals("yes")) {
            addOnCost += 3.95 * daysRented;
            addedOn += "Electronic toll tag\n";
        }

        if (gps.equals("yes")) {
            addOnCost += 2.95 * daysRented;
            addedOn += "GPS\n";
        }

        if (roadsideAssistance.equals("yes")) {
            addOnCost += 3.95 * daysRented;
            addedOn += "Roadside assistance\n";
        }

        double totalCost = rentalCost + addOnCost;

        System.out.println("Hello, you're rental has been approved.");
        System.out.println("Confirm the following details to make sure everything is correct.");
        System.out.println("");
        System.out.println("On " + pickupDate + ", you will be picking up rental for " + daysRented + " days at $29.99/day.");
        System.out.println("You've added on:");
        System.out.println(addedOn);
        System.out.println("Costing an additional: $" + formatCurrency(addOnCost));
        System.out.println("");

        if (age < 25) {
            totalCost *= 1.3;
            System.out.println("Since your under 25, there will be an 30% surcharge added.");
            System.out.println("");
        }

        System.out.println("Total cost: $" + formatCurrency(totalCost));
    }

    public static String formatCurrency(double number) {
        return String.format("%.2f", number);
    }
}
