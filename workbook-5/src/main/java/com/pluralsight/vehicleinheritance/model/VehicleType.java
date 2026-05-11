package com.pluralsight.vehicleinheritance.model;

public enum VehicleType {
    CAR("car"),
    HOVERCRAFT("hovercraft"),
    MOPED("moped"),
    SEMITRUCK("semi-truck");

    private final String displayName;

    VehicleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}