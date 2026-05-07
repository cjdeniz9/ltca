package com.pluralsight.movieplayer;

import java.util.Scanner;

public class MoviePlayer {
    public static void main(String[] args) {

        int choice = getUserChoice();

        boolean mayWatchIt = isOldEnoughToWatch(16,16);

        if (mayWatchIt) {
            playMovie("Superbad");
        }

        handleChoice(choice);

    }

    // 1 method with 1 parameter (and optional value as an arguments)
    public static void playMovie(String title) {
        System.out.println("Playing... " + title);
    }

    public static void pauseMovie() {
        System.out.println("Pausing... Press X button to continue");
        Scanner scanner = new Scanner(System.in);
        String buttonPressed = scanner.nextLine();

        if (buttonPressed.equals("X")) {
            System.out.println("The movie will continue playing");
        } else {
            System.out.println("You pressed something else. The movie is still paused");
        }
    }

    public static boolean isOldEnoughToWatch(int age, int requiredAge) {
        if (age < requiredAge) {
            return false;
        } else {
            return true;
        }
    }

    public static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: ");
        System.out.println("1. Search");
        System.out.println("2. Play movie");
        System.out.println("3. Add to watchlist");
        System.out.print("> ");
        return scanner.nextInt();
    }

    public static void handleChoice(int choice) {
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("Browsing movies...");
                break;
            case 2:
                playMovie("Superbad");
                break;
            case 3:
                System.out.println("Adding to watchlist...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
