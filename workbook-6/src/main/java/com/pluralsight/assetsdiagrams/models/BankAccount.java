package com.pluralsight.assetsdiagrams.models;

public class BankAccount implements Valuable {

    private double debt;

    public BankAccount(double debt) {
        this.debt = debt;
    }

    public double withdraw() {
        return 0;
    }

    public double deposit() {
        return 0;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
