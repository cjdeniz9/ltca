package com.pluralsight.workbook.i.sychronous;

import java.util.ArrayList;
import java.util.Scanner;

public class V {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // An array is a list of values, typically with the same datatype
        String[] names = {"Ringo", "Sparky", "Champagne"};

        // Elements
        // 0-based index... Call a specific element
        System.out.println(names[2]);

        // How many names are in the list
        // There is a method for that called .length
        System.out.println(names.length);

        // The last name is length - 1
        int indexNumOfLastName = names.length - 1;
        System.out.println(names[indexNumOfLastName]);

        System.out.println("Top 3 favorite movies");

        ArrayList<String> favoriteMovies = inputFavoriteMovies(scanner);

        if (favoriteMovies.size() == 3) {
            System.out.println(favoriteMovies);
        }
    }

    public static ArrayList<String> inputFavoriteMovies (Scanner scanner) {
        ArrayList<String> favoriteMovies = new ArrayList<>();

        String[] position = {"first", "second", "third"};

        while (favoriteMovies.size() < 3) {
            System.out.println("Enter your " + position[favoriteMovies.size()] + " favorite movie.");
            String movieTitle = scanner.nextLine();
            favoriteMovies.add(movieTitle);
        }

        return favoriteMovies;
    }
}
