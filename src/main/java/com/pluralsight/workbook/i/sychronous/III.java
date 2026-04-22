package com.pluralsight.workbook.i.sychronous;

import java.util.Scanner;

public class III {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playing = true;
        String choice = "";

        System.out.println("Welcome to GTA Night Run!");
        System.out.println("You wake up in a dark alley...");
        System.out.println("");

        while (playing) {
            if (choice.equals("")) {
                System.out.println("What do you do?");
                System.out.println("1. steal car");
                System.out.println("2. walk away");
                System.out.println("3. rob bank");
                System.out.println("4. hit the clubs");
                System.out.println("5. call Lester");
                System.out.print("> ");
                choice = scanner.nextLine();
                System.out.println("");
            } else if (choice.equals("1")) {
                System.out.println("The cops are here for a pursuit.");
                System.out.println("Do you try to escape or pull over?");
                System.out.print("> ");
                choice = scanner.nextLine();
                System.out.println("");
                if (choice.equals("escape") || choice.equals("try to escape")) {
                    System.out.println("You've made it out!");
                    playing = false;
                } else if (choice.equals("pull over")) {
                    System.out.println("You've been busted.");
                    playing = false;
                } else {
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("");
                    choice = "1";
                }
            } else {
                System.out.println("Invalid choice. Try again.");
                System.out.println("");
                choice = "";
            }
        }

        if (!playing) {
            System.out.println("Game Over");
            scanner.close();
        }
    }
}
