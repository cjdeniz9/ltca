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
    protected double getTotalPrice() {
        return 0;
    }

    @Override
    protected double getMonthlyPayment() {
        return 0;
    }
}
