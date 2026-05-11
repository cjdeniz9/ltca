package com.pluralsight.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    private int roomNumber;
    private RoomType roomType;
    private int numberOfBeds;
    private double pricePerNight;

    @JsonProperty("isDirty")
    private boolean isDirty;

    @JsonProperty("isAvailable")
    private boolean isAvailable;

    // ---------------- EMPTY CONSTRUCTOR (REQUIRED FOR JACKSON) ----------------
    public Room() {
    }

    // ---------------- MAIN CONSTRUCTOR ----------------
    public Room(int roomNumber, RoomType roomType, int numberOfBeds,
                double pricePerNight, boolean isDirty, boolean isAvailable) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;

        updatePricePerNight();
    }

    // ---------------- GETTERS ----------------
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isDirty() {
        return isDirty;
    }

    // ---------------- SETTERS ----------------
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
        updatePricePerNight();
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // ---------------- BUSINESS LOGIC ----------------
    private void updatePricePerNight() {
        if (roomType == null) return;

        pricePerNight = switch (roomType) {
            case KING -> 139;
            case DOUBLE -> 124;
            default -> 0;
        };
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

    // ---------------- DISPLAY ----------------
    public void displayRoomInfo() {
        System.out.println("Room number: " + roomNumber);
        System.out.println("Room type: " + roomType);
        System.out.println("Number of beds: " + numberOfBeds);
        System.out.println("Price per night: $" + pricePerNight);
        System.out.println("Occupied: " + isOccupied());
        System.out.println("Dirty: " + isDirty);
        System.out.println("Available: " + isAvailable);
    }

    @Override
    public String toString() {
        return """
                -------------------------
                Room Number: %d
                Room Type: %s
                Beds: %d
                Price Per Night: $%.2f
                Dirty: %b
                Available: %b
                """.formatted(
                roomNumber,
                roomType,
                numberOfBeds,
                pricePerNight,
                isDirty,
                isAvailable
        );
    }
}