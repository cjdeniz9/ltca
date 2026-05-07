package com.pluralsight.mathapp;

public class MathApp {
    public static void main(String[] args) {

        // Step 1
        // 1.1
        int bobSalary = 65000;
        int garySalary = 90000;

        int highestSalary = Math.max(bobSalary, garySalary);

        System.out.println("The highest salary is $" + highestSalary);

        // 1.2
        int carPrice = 25000;
        int truckPrice = 45000;

        int lowestPrice = Math.min(carPrice, truckPrice);

        System.out.println("The cheapest price is $" + lowestPrice);

        // 1.3
        double radius = 7.25;
        double squared = radius * radius;
        double areaOfCircle = Math.PI *  squared;

        System.out.println("The area of a circle " + areaOfCircle);

        // 1.4
        double num = 5.0;
        double squareRoot = Math.sqrt(num);

        System.out.println("The square root is " + squareRoot);

        // 1.5
        int pointA = 5;
        int pointB = 10;

        int difference = Math.abs(pointA - pointB);

        System.out.println("The distance between point A and B is " + difference + " miles.");

        pointA = 85; pointB = 50;
        difference = Math.abs(pointA - pointB);
        System.out.println("The distance between point A and B is " + difference + " miles.");

        // 1.6
        float negativeNum = -3.8f;

        float positiveNum = Math.abs(negativeNum);

        System.out.println("The absolute value is: " + positiveNum);

        // 1.7
        int startingNum = 0;
        int endingNum = 1;

        float randomNum = (float)(Math.random() * (endingNum - startingNum + 1)) + startingNum;

        System.out.println("Random number selected: " + randomNum);

        // 1.8
        int days = 24;

        int hours = 24;
        int minutes = 60;

        int totalMinutes = (days * hours) * minutes;

        System.out.println("In " + days + " days, there are " + totalMinutes + " minutes.");

        int seconds = 60;
        int milliseconds = 1000;

        int totalMilliseconds = (totalMinutes * seconds) * milliseconds;

        System.out.println("In " + days + " days, there are " + totalMilliseconds + " milliseconds.");
    }
}
