package com.pluralsight.models;

public class SalesContract extends Contract {

    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_LOW = 295.00;
    private static final double PROCESSING_FEE_HIGH = 495.00;
    private static final double PROCESSING_FEE_THRESHOLD = 10_000.00;
    private boolean isFinanced;

    public SalesContract(String dateOfContact, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, boolean isFinanced) {
        super(dateOfContact, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        double salesTaxAmount = vehicleSold.getPrice() * SALES_TAX_RATE;

        double processingFee = vehicleSold.getPrice() < PROCESSING_FEE_THRESHOLD ? PROCESSING_FEE_LOW : PROCESSING_FEE_HIGH;

        return vehicleSold.getPrice() + RECORDING_FEE + salesTaxAmount + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced) {
            double loanInterest = vehicleSold.getPrice() >= PROCESSING_FEE_THRESHOLD ? 0.0425 / 12 : 0.0525 / 12;

            int amountOfMonths = vehicleSold.getPrice() >= PROCESSING_FEE_THRESHOLD ? 48 : 24;

            return getTotalPrice() * (loanInterest / (1 - Math.pow(1 + loanInterest, -amountOfMonths)));
        } else {
            return 0;
        }

    }
}
