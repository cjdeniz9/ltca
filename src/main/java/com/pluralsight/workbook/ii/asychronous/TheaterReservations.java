package com.pluralsight.workbook.ii.asychronous;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter;

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        String[] nameParts = name.trim().split("\\s+");

        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String input = scanner.nextLine();

        LocalDate date = LocalDate.parse(input, inputFormatter);
        String formattedDate = date.format(outputFormatter);

        System.out.println("How many tickets would you like? ");
        int ticketCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        System.out.println(ticketCount + (ticketCount == 1 ? " ticket" : " tickets") + " reserved for " + formattedDate + " under " + nameParts[1] + ", " + nameParts[0]);
    }
}
