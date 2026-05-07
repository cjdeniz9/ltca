package com.pluralsight.workbook.ii.sychronous;

import java.util.Scanner;

public class CalorieTracker {
    public static void main(String[] args) {
        showMenu();
        storeMenuChoice();
    }

    public static void enterCalories() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many calories");
    }

    public static void showMenu() {
        System.out.println("=== Calorie Tracker Menu ===");
        System.out.println("1. Add Calorie Entry");
        System.out.println("2. View Total Calories");
        System.out.println("3. Set Daily Goal");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static void storeMenuChoice() {
        Scanner read = new Scanner(System.in);
        int option = read.nextInt();

        switch (option) {
            case 1:
                addCalories();
                break;
            case 2:
                showCalories(addCalories());
                break;
            case 3:
                setDailyCalorieGoal(addCalories());
                break;
            case 0:
                Exit();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void Exit() {
    }

    private static void setDailyCalorieGoal(int _totalDailyCalories) {
        Scanner scanner = new Scanner(System.in);

        String goal = "";
        int dailyCalorieGoal = 0;

        System.out.println("What is your goal?");
        System.out.println("1. Weight loss");
        System.out.println("2. Maintain Weight");
        System.out.println("3. Build muscle");
        System.out.print("Choose an option: ");
        int goalType = scanner.nextInt();

        if (goalType == 1) {
            dailyCalorieGoal = _totalDailyCalories - 500;
            goal = "For weight loss, ";
        } else if (goalType == 2) {
            dailyCalorieGoal = _totalDailyCalories;
            goal = "To maintain weight, ";
        } else if (goalType == 3) {
            dailyCalorieGoal = _totalDailyCalories + 300;
            goal = "To build muscles, ";
        }  else {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println();
        System.out.println(goal + " your recommend daily calorie goal is: " + dailyCalorieGoal + " kcal");
    }

    private static void showCalories(int _totalDailyCalories) {
        System.out.println("Total daily calories: " + _totalDailyCalories + " kcal");
    }

    private static int addCalories() {
        int breakfastCalories = 0;
        int lunchCalories = 0;
        int dinnerCalories = 0;

        int carbs = 0;
        int fats = 0;
        int protein = 0;

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many grams of carbs did you eat today (in whole numbers)? ");
        carbs = scanner.nextInt();

        System.out.print("How many grams of fats did you eat today (in whole numbers)? ");
        fats = scanner.nextInt();

        System.out.print("How many grams of protein did you eat today (in whole numbers)? ");
        protein = scanner.nextInt();

        System.out.println();

        return (carbs * 4) + (fats * 9) + (protein * 4);
    }
}
