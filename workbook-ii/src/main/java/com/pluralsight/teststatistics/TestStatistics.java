package com.pluralsight.workbook.ii.asychronous;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        int[] testScores = {90, 64, 87, 76, 98, 72, 78, 91, 84, 57};

        int sum = 0;
        int highestScore = testScores[0];
        int lowestScore = testScores[0];

        for (int score : testScores) {
            sum += score;

            if (score > highestScore) {
                highestScore = score;
            }

            if (score < lowestScore) {
                lowestScore = score;
            }
        }

        double average = (double) sum / testScores.length;

        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);

        Arrays.sort(testScores);
        double median;
        int len = testScores.length;

        if (len % 2 == 1) {
            median = testScores[len / 2];
        } else {
            median = (testScores[len / 2 - 1] + testScores[len / 2]) / 2.0;
        }

        double averageMedianDifference = median - average;

        System.out.println("Median: " + median);
        System.out.println("The difference between average and median: " + String.format("%.2f", averageMedianDifference));

    }
}
