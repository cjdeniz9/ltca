package com.pluralsight.gamerstatuschecker;

public class GamerStatusChecker {
    public static void main(String[] args) {
        boolean isActiveGamer = true;
        String game = "GTA";

        if (isActiveGamer && game == "GTA") {
            System.out.println("You're grinding in GTA again 😎");
            System.out.println("Respect!");
        } else {
            System.out.println("Time to play some more games");
        }
    }
}
