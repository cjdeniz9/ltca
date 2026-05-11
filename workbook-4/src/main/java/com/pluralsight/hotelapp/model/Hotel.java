package com.pluralsight.hotelapp.model;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String _name, int _numberOfSuites, int _numberOfRooms) {
        this.name = _name;
        this.numberOfSuites = _numberOfSuites;
        this.numberOfRooms = _numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String _name, int _numberOfSuites, int _numberOfRooms, int _bookedSuites, int _bookedBasicRooms) {
        this.name = _name;
        this.numberOfSuites = _numberOfSuites;
        this.numberOfRooms = _numberOfRooms;
        this.bookedSuites = _bookedSuites;
        this.bookedBasicRooms = _bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        int totalSuites = numberOfRooms + this.bookedSuites;

        return (totalSuites < this.numberOfSuites) && isSuite;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedBasicRooms;
    }
}
