package com.pluralsight.hotelapp.model;

public class Room {

    private  final int roomNumber;
    private final RoomType roomType;
    private final int numberOfBeds;
    private double pricePerNight;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(int _roomNumber, RoomType _roomType, int _numberOfBeds, double _pricePerNight, boolean _isDirty, boolean _isAvailable) {
        this.roomNumber = _roomNumber;
        this.roomType = _roomType;
        this.numberOfBeds = _numberOfBeds;
        this.pricePerNight = setPricePerNight(_pricePerNight);
        this.isDirty = _isDirty;
        this.isAvailable = _isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public RoomType getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double setPricePerNight(double _pricePerNight) {
        return this.pricePerNight = switch (getRoomType()) {
            case KING -> 139;
            case DOUBLE ->  124;
            default -> _pricePerNight;
        };
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void markAsOccupied() {
        isAvailable = false;
    }

    public void markAsAvailable() {
        isAvailable = true;
    }

    public boolean isOccupied() {
        return !isAvailable;
    }

    public void cleanRoom() {
        isDirty = false;
    }

    public void checkIn() {
        isAvailable = false;
        isDirty = true;
    }

    public void checkOut() {
        cleanRoom();
        isAvailable = true;
    }

    public void displayRoomInfo() {
        System.out.println("Room number: " + roomNumber);
        System.out.println("Room type: " + roomType);
        System.out.println("Number of beds: " + numberOfBeds);
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Occupied: " + isOccupied());
        System.out.println("Dirty: " + isDirty);
        System.out.println("Available: " + isAvailable);
    }

}
