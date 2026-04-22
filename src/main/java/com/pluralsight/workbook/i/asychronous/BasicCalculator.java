package com.pluralsight.workbook.i.asychronous;

import java.util.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNum = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");

        System.out.println("Possible calculations:");
        System.out.println("\t(A)dd");
        System.out.println("\t(S)ubtract");
        System.out.println("\t(M)ultiply");
        System.out.println("\t(D)ivide");

        System.out.print("Please select an option: ");
        String arithmeticOperators = scanner.nextLine();

        System.out.println("");

        switch (arithmeticOperators.toLowerCase()) {
            case "a"  -> System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
            case "s" -> System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
            case "m" -> System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
            case "d" -> System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
            default -> System.out.println("Invalid operator!");
        }
    }
}
