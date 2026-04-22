package com.pluralsight.workbook.i.asychronous;

import java.util.Scanner;

public class MortageCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        showMenu(); // ❗ Hint: something is missing here to CALL the method
        int choice = getUserChoice();

        if (choice == 1) { // ❗ Hint: are you comparing or assigning?
            System.out.print("Enter loan amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter years: ");
            int years = scanner.nextInt();

            // ❗ Hint: check the order of parameters in the method definition
            double result = calculateMonthlyPayment(principal, rate, years);
            System.out.println("Monthly payment: " + result);
        }
        else if (choice == 2) {
            System.out.print("Enter deposit amount: ");
            double deposit = scanner.nextDouble();

            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter years: ");
            int years = scanner.nextInt();

            // ❗ Hint: are you passing all required parameters?
            double result = calculateFutureValue(deposit, rate, years);
            System.out.println("Future value: " + result);
        }

    }

    public static void showMenu() {
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
    }

    public static int getUserChoice() {
        System.out.print("Choose: ");
        return scanner.nextInt(); // ❗ Hint: where is the return value?
    }

    public static double calculateMonthlyPayment(double principal, double annualRate, int years) {
        double monthlyRate = annualRate / 12;
        int numberOfPayments = years * 12;

        return principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        // ❗ Hint: this method should return something
    }

    public static double calculateFutureValue(double deposit, double rate, int years) {
        return deposit * Math.pow(1 + (rate / 365), 365 * years);

        // ❗ Hint: what value should be returned here?
    }
}
