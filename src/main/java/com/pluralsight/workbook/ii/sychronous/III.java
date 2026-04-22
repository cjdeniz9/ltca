package com.pluralsight.workbook.ii.sychronous;

public class III {
    public static void main(String[] args) {
        String[] playlist = {
                "Last Nite",
                "Someday",
                "Reptilia",
                "Under Cover of Darkness",
                "The Adults Are Talking"
        };

        // Using for-each (play ALL songs)
        System.out.println("=== for-each ====");
        for (String song : playlist) {
            System.out.println("Now playing: " + song);
        }

        System.out.println();
        System.out.println("=== for ===");
        // Using for (play every SECOND song)
        for (int i = 0; i < playlist.length; i += 2) {
            System.out.println("Now playing: " + playlist[i]);
        }
    }
}
