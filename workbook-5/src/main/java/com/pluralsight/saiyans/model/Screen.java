package com.pluralsight.saiyans.model;

public enum Screen {
    HOME, SAIYAN, NAMEKIAN, TEAM, TEAMPOWER, BATTLE, REPORT, EXIT;

    public static Screen fromInt(int i) {
        return switch (i) {
            case 1 -> SAIYAN;
            case 2 -> NAMEKIAN;
            case 3 -> TEAM;
            case 4 -> TEAMPOWER;
            case 5 -> BATTLE;
            case 6 -> REPORT;
            case 0 -> EXIT;
            default -> HOME;
        };
    }
}