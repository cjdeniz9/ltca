package com.pluralsight.receipt;

public class Receipt {
    public static void main(String[] args) {
        String itemName = "apples";
        double price = 7.10;
        int quantity = 3;

        System.out.println("You bought " + quantity + " " + itemName + " for $" + price);
    }
}
