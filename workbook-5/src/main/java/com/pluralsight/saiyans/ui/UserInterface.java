package com.pluralsight.saiyans.ui;

import com.pluralsight.saiyans.model.Screen;
import com.pluralsight.saiyans.service.FighterManager;
import com.pluralsight.saiyans.service.ScreenManager;

public class UserInterface {

    ScreenManager screenManager = new ScreenManager();
    FighterManager fighterManager = new FighterManager();

    public void start() {
        Screen currentScreen = Screen.HOME;
        
        while(currentScreen != Screen.EXIT) {
            switch (currentScreen) {
                case SAIYAN -> currentScreen = createSaiyan();
                case NAMEKIAN -> currentScreen = createNamekian();
                case TEAM -> currentScreen = viewTeam();
                default -> currentScreen = home();
            }
            
        }
    }

    private Screen createSaiyan() {
        System.out.println();

        fighterManager.addFighterToTeam("Saiyan");

        return Screen.HOME;
    }

    private Screen createNamekian() {
        System.out.println();

        fighterManager.addFighterToTeam("Namekian");

        return Screen.HOME;
    }

    private Screen viewTeam() {
        System.out.println();

        System.out.println("=== MY TEAM ===");

        fighterManager.displayTeam();

        System.out.println();

        return Screen.HOME;
    }

    private void header() {

        String G2 = "\u001B[38;5;220m";
        String G3 = "\u001B[38;5;214m";
        String G4 = "\u001B[38;5;208m";
        String WH = "\u001B[38;5;255m";
        String DM = "\u001B[38;5;136m";
        String R  = "\u001B[0m";

        // TOP / BOTTOM BORDERS ONLY
        String TOP = G2 + "  ╔════════════════════════════════════════════════════════════╗" + R;
        String MID = G2 + "  ╠════════════════════════════════════════════════════════════╣" + R;
        String BOT = G2 + "  ╚════════════════════════════════════════════════════════════╝" + R;

        // LEFT PADDING
        String P = "     ";

        System.out.println();

        System.out.println(TOP);
        System.out.println();

        // LOGO
        System.out.println(P + G2 + "██████╗ ██████╗ ███████╗");
        System.out.println(P + G2 + "██╔══██╗██╔══██╗╚════██║   BATTLE ARENA");
        System.out.println(P + G3 + "██║  ██║██████╔╝    ██╔╝   ─────────────");
        System.out.println(P + G3 + "██║  ██║██╔══██╗   ██╔╝    SUPER SAIYAN ED.");
        System.out.println(P + G4 + "██████╔╝██████╔╝   ██║");
        System.out.println(P + G4 + "╚═════╝ ╚═════╝    ╚═╝");

        System.out.println();
        System.out.println(MID);
        System.out.println();

        // MENU
        System.out.println(P + WH + "[1]" + G2 + " Create Saiyan      " + WH + "[2]" + G2 + " Create Namekian");
        System.out.println(P + WH + "[3]" + G2 + " View Team          " + WH + "[4]" + G2 + " Total Power");
        System.out.println(P + WH + "[5]" + G2 + " Start Battle       " + WH + "[6]" + G2 + " Save Report");
        System.out.println(P + WH + "[0]" + G2 + " Exit");

        System.out.println();
        System.out.println(BOT);
        System.out.println();

        System.out.print(G2 + "  >> " + WH);
    }

    private Screen home() {
        header();

        int option = screenManager.getIntInput(1, 2, 3, 4, 5, 6, 0);
        System.out.println("\u001B[0m");

        return Screen.fromInt(option);
    }

    private void loading(String message) {
        String[] frames = {"|", "/", "-", "\\"};
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print("\r" + message + " " + frames[i % 4]);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }

    private void intro() {
        try {
            String intro = "Welcome to DBZ Battle Arena...";
            for (char c : intro.toCharArray()) {
                System.out.print(c);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
