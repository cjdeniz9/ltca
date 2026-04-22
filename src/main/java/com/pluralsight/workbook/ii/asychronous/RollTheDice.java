package com.pluralsight.workbook.ii.asychronous;

class Dice {
    int roll1;
    int roll2;
    int twoCounter;
    int fourCounter;
    int sixCounter;
    int sevenCounter;
}
public class RollTheDice {
    public static void main(String[] args) {
        Dice dice = new Dice();

        for (int i = 1; i <= 100; i++) {
            dice.roll1 = roll();
            dice.roll2 = roll();

            int sum = dice.roll1 + dice.roll2;

            System.out.println("Roll " + i + ": " + dice.roll1 + " - " + dice.roll2 + " Sum: " + sum);

            if (sum == 2) {
                dice.twoCounter++;
            } else if (sum == 4) {
                dice.fourCounter++;
            } else if (sum == 6) {
                dice.sixCounter++;
            } else if (sum ==7) {
                dice.sevenCounter++;
            }
        }

        System.out.println();
        System.out.println("=== COUNTER ===");
        System.out.println("Amount of times the pair of dice rolled a 2, 4, 6, or 7");
        System.out.println("2: " + dice.twoCounter);
        System.out.println("4: " + dice.fourCounter);
        System.out.println("6: " + dice.sixCounter);
        System.out.println("7: " + dice.sevenCounter);
    }

    public static int roll() {
        int minValue = 1;
        int maxValue = 6;

        return (int)(Math.random() * maxValue) + minValue;
    }
}
