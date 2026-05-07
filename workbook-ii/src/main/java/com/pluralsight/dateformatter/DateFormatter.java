package com.pluralsight.workbook.ii.sychronous;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void main(String[] args) {
        // STEP 1: Store the input date as a String
        // This is how a user or system might provide a date
        String input = "22/11/1999";

        // STEP 2: Create a formatter that MATCHES the input format
        // Pattern explanation:
        // dd = day (2 digits)
        // MM = month (2 digits)
        // yyyy = full year (4 digits)
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // STEP 3: (Optional) Create another formatter for OUTPUT
        // This lets us display the date in a different format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // STEP 4: Convert (parse) the String into a LocalDate object
        // Java now understands this as a real date instead of plain text
        LocalDate date = LocalDate.parse(input, inputFormatter);

        // STEP 5: Format the LocalDate into a new String format
        // We use the outputFormatter to change how it is displayed
        String formattedDate = date.format(outputFormatter);

        // STEP 6: Print the result
        System.out.println("Formatted date: " + formattedDate);

    }
}
