package com.pluralsight.workbook.iii.asychronous.searchinventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class StoreApp {

    // For Exercises - Search Inventory HashMap [Section 4-1]
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Product> inventory = loadInventory();

        System.out.print("Search product: ");
        String name = scanner.nextLine();

        Product matchedProduct = inventory.get(name.toLowerCase());

        if (matchedProduct == null) {
            System.out.println("Sorry, we don't carry that product");
            return;
        }

        System.out.printf("We carry %s and the price is %.2f", matchedProduct.getName(), matchedProduct.getPrice());
    }

        public static HashMap<String, Product> loadInventory() {
        InventoryFileReader fileReader = new InventoryFileReader();
        // this method loads product objects into inventory
        // and its details are not shown

        return fileReader.readInventoryFromCsv("workbook/iii/asychronous/inventory.csv");
    }

    // For Exercises - Search Inventory [Section 3-2]
//    public static void main(String[] args) {
//
//        ArrayList<Product> inventory = getInventory();
//
//        Collections.sort(inventory, (a, b) -> a.getName().compareTo(b.getName()));
//
//        System.out.println("We carry the following products: ");
//        for (Product p : inventory) {
//            System.out.printf("id: %d %s - Price: $%.2f%n",
//                    p.getId(), p.getName(), p.getPrice());
//        }
//    }
//
//    public static ArrayList<Product> getInventory() {
//        InventoryFileReader fileReader = new InventoryFileReader();
//        // this method loads product objects into inventory
//        // and its details are not shown
//
//        return (ArrayList<Product>) fileReader.readInventoryFromCsv("workbook/iii/asychronous/inventory.csv");
//    }
}
