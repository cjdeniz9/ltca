package com.pluralsight.workbook.iii.asychronous;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isOpen = true;

        handleFileWriter("launch", false);

        while (isOpen) {
            System.out.print("Enter a search term (X to exit): ");
            String searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("x")) {
                isOpen = false;
                handleFileWriter("exit", false);
            } else if (!searchTerm.isEmpty()) {
                handleFileWriter(searchTerm, true);
            }
        }

        scanner.close();
    }

    public static void handleFileWriter(String searchTerm, boolean isSearch) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        String formattedDate = dateTime.format(fmt);

        String logEntry = isSearch
                ? formattedDate + " search : " + searchTerm + "\n"
                : formattedDate + " " + searchTerm + "\n";

        try (FileWriter writer = new FileWriter("src/main/resources/workbook/iii/asychronous/log.txt", true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}