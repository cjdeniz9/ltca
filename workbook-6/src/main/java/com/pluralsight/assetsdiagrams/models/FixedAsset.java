package com.pluralsight.assetsdiagrams.models;

public abstract class FixedAsset implements Valuable {

    protected String name;
    protected double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    @Override
    public abstract double getValue();

}
