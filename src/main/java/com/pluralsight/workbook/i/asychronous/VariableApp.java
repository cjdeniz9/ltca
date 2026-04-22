package com.pluralsight.workbook.i.asychronous;

public class VariableApp {
    public static void main(String[] args) {
        // Step 1
        String favoriteColor = "blue";
        short yearClassStarted = 2026;
        char middleInitial = 'J';
        boolean hasPet = false;
        String niceSaying = "Peace and love";

        System.out.println(favoriteColor);
        System.out.println(yearClassStarted);
        System.out.println(middleInitial);
        System.out.println(hasPet);
        System.out.println(niceSaying);

        // Step 2
        final int weekdays = 7;
        double coffeePrice = 4.99;
        char favoriteLetter = 'J';
        boolean isRaining = false;

        System.out.println("There are " + weekdays + " days in a week");
        System.out.println("The is coffee cost $" + coffeePrice);
        System.out.println("My favorite letter is " + favoriteLetter);
        System.out.println("Is it raining? " + isRaining);
    }
}
