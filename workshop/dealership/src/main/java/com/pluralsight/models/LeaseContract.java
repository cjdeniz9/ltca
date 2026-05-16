package com.pluralsight.models;

public class LeaseContract extends Contract {

    private static final double EXPECTED_ENDING_VALUE_RATE = 0.50;
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double LEASE_INTEREST_RATE = 0.04 / 12;
    private static final int LEASE_MONTHS = 36;

    private final double expectedEndingValue;
    private final double leaseFee;

    public LeaseContract(String dateOfContact, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContact, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * EXPECTED_ENDING_VALUE_RATE;
        this.leaseFee = vehicleSold.getPrice() * LEASE_FEE_RATE;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return getTotalPrice() * (LEASE_INTEREST_RATE / (1 - Math.pow(1 + LEASE_INTEREST_RATE, -LEASE_MONTHS)));
    }

    @Override
    public String toCsvLine() {
        return String.join("|",
                "LEASE",
                dateOfContact,
                customerName,
                customerEmail,
                String.valueOf(vehicleSold.getVin()),
                String.valueOf(vehicleSold.getYear()),
                vehicleSold.getMake(),
                vehicleSold.getModel(),
                vehicleSold.getVehicleType().getDisplayName(),
                vehicleSold.getColor(),
                String.valueOf(vehicleSold.getOdometer()),
                String.format("%.2f", vehicleSold.getPrice()),
                String.format("%.2f", expectedEndingValue),
                String.format("%.2f", leaseFee),
                String.format("%.2f", getTotalPrice()),
                String.format("%.2f", getMonthlyPayment())
        );
    }
}