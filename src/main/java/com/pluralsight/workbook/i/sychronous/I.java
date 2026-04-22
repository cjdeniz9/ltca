package com.pluralsight.workbook.i.sychronous;

import java.util.*;

public class I {
    public static void delayTimer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 71000.00;

        System.out.println("Welcome to Bank of America");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        int pincode = 90650;
        int attempts = 3;
        int enteredPincode = 0;

        while (attempts > 0 && enteredPincode != pincode ) {
            System.out.println("");
            System.out.print("Type in your pincode: ");
            enteredPincode = scanner.nextInt();

            if (enteredPincode == pincode) {
                System.out.println("Welcome " + username + ", your pincode is correct.");
                delayTimer();
                System.out.println("Access granted.");
                delayTimer();

                int enteredOption = 0;
                double withdrawnBalance = balance - 100;

                while (enteredOption < 1 || enteredOption > 3) {
                    System.out.println("");
                    System.out.println("1. Balance");
                    System.out.println("2. Withdraw $100");
                    System.out.println("3. Deposit");
                    System.out.print("Pick an option: ");
                    enteredOption = scanner.nextInt();

                    if (enteredOption == 1) {
                        System.out.println("Your balance is $" + String.format("%.2f", balance) + ".");
                    } else if (enteredOption == 2 && withdrawnBalance >= 0) {
                        System.out.println("");
                        System.out.println("Withdrawing $100...");
                        delayTimer();
                        System.out.println("");
                        System.out.println("Your updated balance is $" + String.format("%.2f", withdrawnBalance) + ".");
                    } else if (enteredOption == 2 && withdrawnBalance < 0) {
                        System.out.println("Insufficient funds.");
                    } else if (enteredOption == 3) {
                        System.out.println("");
                        System.out.print("Enter the amount you'll like to deposit: ");
                        double deposit = scanner.nextDouble();

                        if (deposit > 0) {
                            double newBalance = balance + deposit;
                            System.out.println("Depositing $" + String.format("%.2f", deposit) + "...");
                            delayTimer();
                            System.out.println("Your new balance is $" + String.format("%.2f", newBalance) + ".");
                        } else {
                            System.out.println("Deposit must be greater than 0.");
                        }

                        enteredOption = 3;
                    } else {
                        System.out.println("");
                        System.out.println("Please select only one of the three options.");
                        delayTimer();
                    }

                }

            } else {
                System.out.println(username + ", your pincode is incorrect.");
                attempts--;
                System.out.println("You only have " + attempts + " left." );
            }
        }

        scanner.close();

        if (attempts == 0 ) {
            System.out.println("You've been locked out.");
        }
    }
}
