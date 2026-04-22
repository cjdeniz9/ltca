package com.pluralsight.workbook.ii.sychronous.netflix;

public class Movie {

    String name;
    String genre;
    int runtimeMinutes;

    // Constructor
    public Movie(String _name, String _genre, int _runtimeMinutes) {
        this.name = _name;
        this.genre = _genre;
        this.runtimeMinutes = _runtimeMinutes;
    }

    void displayInfo () {
        System.out.println("Currently watching a " + genre + " movie called " + name);
    }

    void play () {

    }

    void pause () {

    }

    void getDetails () {

    }

    void rateMovie () {

    }

}
