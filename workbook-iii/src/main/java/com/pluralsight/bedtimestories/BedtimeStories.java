package com.pluralsight.workbook.iii.asychronous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Choose one of the three bedtime stories to read:");
            System.out.println("1. Goldilocks and the Three Bears");
            System.out.println("2. Hansel and Gretel");
            System.out.println("3. Mary had a little lamb");
            System.out.print("> ");
            int input = scanner.nextInt();

            String storySelected = "";

            if (input == 1) {
                storySelected = "goldilocks.txt";
            } else if (input == 2) {
                storySelected = "hansel-and-gretel.txt";
            } else if (input == 3) {
                storySelected = "mary-had-a-little-lamb.txt";
            }

            BufferedReader bufReader = new BufferedReader(new FileReader(storySelected));

            while (bufReader.readLine() != null) {
                System.out.println( );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
