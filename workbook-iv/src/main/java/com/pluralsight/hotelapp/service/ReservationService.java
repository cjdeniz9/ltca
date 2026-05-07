package com.pluralsight.hotelapp.service;

import com.pluralsight.hotelapp.model.Reservation;
import com.pluralsight.hotelapp.model.Room;

public class ReservationService {

    public void confirmReservation(Reservation reservation) {
        reservation.confirmReservation();
    }

    public void cancelReservation(Reservation reservation) {
        reservation.cancelReservation();
    }

    public long calculateNumberOfNights(Reservation reservation) {
        return reservation.getNumberOfNights();
    }

    public double calculateTotalPrice(Reservation reservation) {
        return reservation.getReservationTotal();
    }

    public void displayReservationSummary(Room room, Reservation reservation) {
        System.out.println("""
        Price per night: $%.2f
        Number of nights: %d
        Weekend (10%% surcharge if true): %b
        Reservation total: $%.2f
        """.formatted(
                room.getPricePerNight(),
                reservation.getNumberOfNights(),
                reservation.isWeekend(),
                reservation.getReservationTotal()
        ));
    }
}
