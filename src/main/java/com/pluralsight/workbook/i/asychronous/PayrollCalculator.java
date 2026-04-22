package com.pluralsight.workbook.i.asychronous;

import java.util.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Hours worked: ");
        float hoursWorked = scanner.nextFloat();

        System.out.print("Pay rate: ");
        float payRate = scanner.nextFloat();
        scanner.nextLine();

        double grossPay = calculateGrossPay(hoursWorked, payRate);

        System.out.println("");
        System.out.println("The employee " + name + " grossed $" + formatCurrency(grossPay) + " for the week.");
    }

    public static String formatCurrency(double number) {
        return String.format("%.2f", number);
    }

    public static double calculateGrossPay(float hoursWorked, float payRate) {
        if (hoursWorked > 40) {
            double overtime = Math.abs(hoursWorked - 40);
            return (40 * payRate) + (overtime * (payRate * 1.5));
        } else {
            return hoursWorked * payRate;
        }
    }
}
