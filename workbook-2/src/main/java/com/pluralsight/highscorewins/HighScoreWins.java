package com.pluralsight.workbook.ii.asychronous;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWinner(getUserInput(scanner));
    }

    public static String getUserInput(Scanner scanner) {
        System.out.println("Please enter a game score [ex: Home:Visitor|21:9] ");
        System.out.print("> ");
        return scanner.nextLine();
    }

    public static void displayWinner(String _gameScore) {
        String[] tokens = _gameScore.split("[|:]");

        int homeTeam = Integer.parseInt(tokens[2]);
        int awayTeam = Integer.parseInt(tokens[3]);

        if (homeTeam > awayTeam) {
            System.out.println("Winner: " + tokens[0]);
        } else {
            System.out.println("Winner: " + tokens[1]);
        }
    }

}
