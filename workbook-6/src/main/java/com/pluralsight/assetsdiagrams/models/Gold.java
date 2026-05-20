package com.pluralsight.assetsdiagrams.models;

public class Gold extends FixedAsset{

    private double weight;

    public Gold(double weight) {
        super("", 0);
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return 0;
    }

}
