package com.pluralsight.calculator;

public class Calculator {

    /// Not connectod to any instance of calculator
    /// Generic method that can be called by any calculator
    public static void add(int number1, int number2) {
        int total = number1 + number2;
    }

    ///Connected to a specific calculator
    public static void add(int number1, int number2, int number3) {
        int total = number1 + number2 + number3;
    }

    public static void add(double number1, double number2) {
        double total = number1 + number2;
    }
}