package com.pluralsight.models;

public class SalesContract extends Contract {

    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_LOW = 295.00;
    private static final double PROCESSING_FEE_HIGH = 495.00;
    private static final double PROCESSING_FEE_THRESHOLD = 10_000.00;

    private final double salesTax;
    private final double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContact, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContact, customerName, customerEmail, vehicleSold);
        this.salesTax = vehicleSold.getPrice() * SALES_TAX_RATE;
        this.processingFee = vehicleSold.getPrice() < PROCESSING_FEE_THRESHOLD ? PROCESSING_FEE_LOW : PROCESSING_FEE_HIGH;
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
        return vehicleSold.getPrice() + RECORDING_FEE + salesTax + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced) {
            double loanInterest = vehicleSold.getPrice() >= PROCESSING_FEE_THRESHOLD ? 0.0425 / 12 : 0.0525 / 12;
            int amountOfMonths = vehicleSold.getPrice() >= PROCESSING_FEE_THRESHOLD ? 48 : 24;
            return vehicleSold.getPrice() * (loanInterest / (1 - Math.pow(1 + loanInterest, -amountOfMonths)));
        } else {
            return 0;
        }
    }

    @Override
    public String toCsvLine() {
        return String.join("|",
                "SALE",
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
                String.format("%.2f", salesTax),
                String.format("%.2f", RECORDING_FEE),
                String.format("%.2f", processingFee),
                String.format("%.2f", getTotalPrice()),
                isFinanced ? "YES" : "NO",
                String.format("%.2f", getMonthlyPayment())
        );
    }
}