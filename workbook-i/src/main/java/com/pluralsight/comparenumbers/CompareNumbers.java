package com.pluralsight.comparenumbers;

public class CompareNumbers {
    public static void main(String[] args) {
        System.out.println(isEven(3));
        System.out.println(isPositive(-1));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPositive(double number) {
        return number > 0;
    }
}
