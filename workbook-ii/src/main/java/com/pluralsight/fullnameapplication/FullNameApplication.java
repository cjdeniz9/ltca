package com.pluralsight.workbook.ii.asychronous;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Suffix: ");
        String suffix = scanner.nextLine();

        String fullName = firstName.trim();

        if (middleName != null && !middleName.isBlank()) {
            fullName += " " + middleName.trim();
        }

        fullName += " " + lastName.trim();

        if (suffix != null && !suffix.isBlank()) {
            fullName += ", " + suffix.trim();
        }

        System.out.println("Full name: " + fullName);
    }
}
