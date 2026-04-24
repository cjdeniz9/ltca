package com.pluralsight.workbook.iii.asychronous.searchinventory;

import java.util.ArrayList;
import java.util.Collections;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();

        Collections.sort(inventory, (a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("We carry the following products: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        InventoryFileReader fileReader = new InventoryFileReader();

        // this method loads product objects into inventory
        // and its details are not shown
        return (ArrayList<Product>) fileReader.readInventoryFromCsv("workbook/iii/asychronous/inventory.csv");
    }
}
