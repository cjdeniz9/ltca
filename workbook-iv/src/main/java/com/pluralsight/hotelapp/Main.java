package com.pluralsight.hotelapp;

import com.pluralsight.hotelapp.model.*;
import com.pluralsight.hotelapp.ui.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

         UserInterface ui = new UserInterface();
         ui.start();

    }

    public static void addPunchTimeCard(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter when you clocked in (Use 24-hour time and enter top of the hour): ");

        int clockInTime = scanner.nextInt();

        System.out.print("Enter when you clocked in (Use 24-hour time and enter top of the hour): ");
        int clockOutTime = scanner.nextInt();

        double hoursWorked = employee.punchTimeCard(clockInTime, clockOutTime);

        System.out.println("Updated hours worked: " + hoursWorked);

    }

}
