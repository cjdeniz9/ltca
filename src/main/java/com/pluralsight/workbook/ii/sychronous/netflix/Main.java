package com.pluralsight.workbook.ii.sychronous.netflix;

public class Main {
    public static void main(String[] args) {

        UserProfile user1 = new UserProfile();
        user1.username = "cjdeniz";
        user1.age = 27;
        user1.preferredGenre = "Comedy";

        Movie m1 = new Movie("The Perks of Being a Wallflower", "Romance/Comedy", 105);
//        m1.name = "The Perks of Being a Wallflower";
//        m1.genre = "Romance/Comedy";
//        m1.runtimeMinutes = 105;


        Movie m2 = new Movie("Saltburn", "Thriller/Comedy", 131);
//        m2.name = "Saltburn";
//        m2.genre = "Thriller/Comedy";
//        m2.runtimeMinutes = 131;

        Movie m3 = new Movie("Superbad", "Comedy/Teen", 119);
//        m3.name = "Superbad";
//        m3.genre = "Comedy/Teen";
//        m3.runtimeMinutes = 119;

        m1.displayInfo();
        m2.displayInfo();
        m3.displayInfo();
    }
}
