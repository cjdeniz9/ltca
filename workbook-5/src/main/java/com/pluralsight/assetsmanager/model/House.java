package com.pluralsight.assetsmanager.model;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double houseValue = switch (condition) {
            case 1 -> 180 * squareFoot;
            case 2 -> 130 * squareFoot;
            case 3 -> 90 * squareFoot;
            case 4 -> 80 * squareFoot;
            default -> -1.0;
        };

        if (houseValue == -1.0) {
            System.out.println("Invalid condition!");
            return -1.0;
        }

        double lotFee = lotSize * 0.25;

        return houseValue + lotFee;
    }
}
