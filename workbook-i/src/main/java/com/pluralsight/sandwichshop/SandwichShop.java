package com.pluralsight.sandwichshop;

import java.util.*;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");

        System.out.println("Sandwich sizes:");
        System.out.println("Regular: $5.45");
        System.out.println("Large: $8.95");

        System.out.println("");

        System.out.print("What size sandwich would you like? ");
        String sandwichSize = scanner.nextLine();

        System.out.print("Would you like everything on the sandwich? ");
        String loaded = scanner.nextLine();

        System.out.print("How old are you, just checking if you qualify for any discount. ");
        int customersAge = scanner.nextInt();
        scanner.nextLine();

        double cost = 0.0;
        String lowerCaseSandwichSize = sandwichSize.toLowerCase();

        if (lowerCaseSandwichSize.equals("regular")) {
            double isLoaded = (loaded.equals("yes") ? 1 : 0);
            cost = 5.45 + isLoaded;

            if (customersAge <= 17) {
                cost *= 1.1;
            } else if (customersAge >= 65) {
                cost *= 1.2;
            }
        } else if (lowerCaseSandwichSize.equals("large")) {
            if (customersAge <= 17) {
                cost = 8.95 * 1.1;
            } else if (customersAge >= 65) {
                cost = 8.95 * 1.2;
            } else {
                cost = 8.95;
            }
        }

        String currencyFormat = String.format("%.2f", cost);

        System.out.println("Total cost of sandwich: $" + currencyFormat);
    }
}
