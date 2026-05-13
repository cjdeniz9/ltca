package com.pluralsight.abstractassetsmanager.model;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double carValue = 0.0;

        if (year >= 0 && year <= 3) {
            carValue = getOriginalCost() * 0.97;
        } else if (year >= 4 && year <= 6) {
            carValue = getOriginalCost() * 0.94;
        } else if (year >= 7 && year <= 10) {
            carValue = getOriginalCost() * 0.92;
        } else if (year > 10) {
            carValue = getOriginalCost() - 1000;
        }

        if ((odometer > 100000) && (!makeModel.equalsIgnoreCase("honda") && !makeModel.equalsIgnoreCase("toyota"))) {
            carValue *= 0.75;
        }

        return carValue;
    }
}
