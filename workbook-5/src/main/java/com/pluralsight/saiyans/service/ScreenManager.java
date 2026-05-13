package com.pluralsight.saiyans.service;

import java.util.Arrays;
import java.util.Scanner;

public class ScreenManager {

    private final Scanner scanner;

    public ScreenManager() {
        this.scanner = new Scanner(System.in);
    }

    // Validates integer input, optionally restricting to a set of valid options
    public int getIntInput(int... validOptions) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.print("Field cannot be empty! Please enter a number: ");
            } else {
                try {
                    input = Integer.parseInt(line);

                    if (validOptions.length == 0) {
                        validInput = true; // any number accepted
                    } else {
                        for (int option : validOptions) {
                            if (input == option) {
                                validInput = true;
                                break;
                            }
                        }
                        if (!validInput) {
                            System.out.print("Invalid option! Only enter one of these options [ " +
                                    Arrays.toString(validOptions).replaceAll("[\\[\\]]", "") + " ]: ");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid option! Please enter a number: ");
                }
            }
        }

        return input;
    }

    public String getStringInput(String... validOptions) {
        String input = scanner.nextLine();

        if (validOptions.length == 0) {
            // No valid options specified — accept any non-empty input
            while (input.trim().isEmpty()) {
                System.out.print("Field cannot be empty: ");
                input = scanner.nextLine();
            }
            return input;
        }

        while (true) {
            // Reject empty input or input that doesn't match a valid option
            if (input.trim().isEmpty()) {
                System.out.print("Field cannot be empty! Please enter a option: ");
            } else {
                for (String option : validOptions) {
                    if (input.equalsIgnoreCase(option)) {
                        return input; // valid option found, return it
                    }
                }
                System.out.print("Invalid option! Only enter one of these options [ " + String.join(", ", validOptions) + " ]: ");
            }
            input = scanner.nextLine();
        }
    }

}
