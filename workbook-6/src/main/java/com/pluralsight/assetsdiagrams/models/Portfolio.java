package com.pluralsight.assetsdiagrams.models;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private String name;
    private String owner;
    private List<Valuable> valuables = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Valuable valuable) {
        valuables.add(valuable);
    }

    public double getValue() {
        return 0;
    }
}
