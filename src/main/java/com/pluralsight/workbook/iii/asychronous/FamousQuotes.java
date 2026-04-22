package com.pluralsight.workbook.iii.asychronous;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] quotes = {
                "The only thing we have to fear is fear itself. - Franklin D. Roosevelt",
                "I think, therefore I am. - René Descartes",
                "Be yourself; everyone else is already taken. - Oscar Wilde",
                "In the middle of difficulty lies opportunity. - Albert Einstein",
                "The unexamined life is not worth living. - Socrates",
                "That which does not kill us makes us stronger. - Friedrich Nietzsche",
                "To be or not to be, that is the question. - William Shakespeare",
                "I have a dream. - Martin Luther King Jr.",
                "Stay hungry, stay foolish. - Steve Jobs",
                "Knowledge is power. - Francis Bacon"
        };

        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Pick a quote (#1 - #10) or (#0) for random quote: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (index == 0) {
                    int min = 0;
                    int max = 9;

                    int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

                    System.out.println(quotes[randomNum]);
                } else {
                    index--;
                    System.out.println(quotes[index]);
                }

                System.out.println();
                System.out.print("Would you like to pick another quote? ");
                String input = scanner.nextLine();
                System.out.println();

                valid = !input.equalsIgnoreCase("yes");
            } catch (Exception e) {
                System.out.println("Your number was out of range!");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
