package com.pluralsight.hotelapp.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isWeekend;

    public Reservation(Guest _guest, Room _room, LocalDate _checkInDate, LocalDate _checkOutDate, boolean _isWeekend) {
        this.guest = _guest;
        this.room = _room;
        this.checkInDate = _checkInDate;
        this.checkOutDate = _checkOutDate;
        this.isWeekend = _isWeekend;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest _guest) {
        this.guest = _guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room _room) {
        this.room = _room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate _checkInDate) {
        this.checkInDate = _checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate _checkOutDate) {
        this.checkOutDate = _checkOutDate;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean _isWeekend) {
        isWeekend = _isWeekend;
    }

    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public double getReservationTotal() {
        long numberOfNight = getNumberOfNights();

        double pricePerNight = room.getPricePerNight();

        if (isWeekend) {
            pricePerNight *= 1.1;
        }

        return pricePerNight * numberOfNight;
    }

    public void confirmReservation() {
        room.markAsOccupied();
        System.out.println("Reservation confirmed.");
    }

    public void cancelReservation() {
        room.markAsAvailable();
        System.out.println("Reservation cancelled.");
    }

}
