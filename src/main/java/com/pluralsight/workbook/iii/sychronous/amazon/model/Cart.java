package com.pluralsight.workbook.iii.sychronous.amazon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EXERCISE: Complete the Cart class
 *
 * Instructions:
 * Replace all TODO comments with working code.
 */
public class Cart {

    // TODO 1: Create a private list that stores Product objects
    // Hint: Use List<Product> and ArrayList
    private List<Product> items = new ArrayList<>();

    /**
     * Adds a product to the cart.
     */
    public void addProduct(Product product) {

        // TODO 2: Check if the product is null
        // If null → throw IllegalArgumentException
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        // TODO 3: Add the product to the list
        items.add(product);
    }

    /**
     * Removes a product from the cart.
     */
    public void removeProduct(Product product) {

        // TODO 4: Remove the product from the list

    }

    /**
     * Returns all products in the cart.
     */
    public List<Product> getItems() {

        // TODO 5: Return a read-only version of the list
        // Hint: Collections.unmodifiableList(...)
        return Collections.unmodifiableList(items);
    }

    /**
     * Returns the number of items in the cart.
     */
    public int getItemCount() {

        // TODO 6: Return the size of the list
        return items.size();
    }

    /**
     * Checks whether the cart is empty.
     */
    public boolean isEmpty() {

        // TODO 7: Return true if the cart is empty
        return items.isEmpty();
    }

    /**
     * Removes all products from the cart.
     */
    public void clear() {

        // TODO 8: Clear the list
        items.clear();
    }

    /**
     * Calculates the total price.
     */
    public double getTotalPrice() {

        // TODO 9: Create a variable to store the total (double total = 0;)
        double total = 0;

        // TODO 10: Loop over all products (for-each loop)
        // TODO 11: Add each product price to total
        // Hint: product.getPrice()

        for (Product product : items) {
            total += product.getPrice();
        }

        // TODO 12: Return the total
        return total;
    }

    /**
     * (Optional Bonus)
     * Prints all products in the cart.
     */
    public void printItems() {

        // TODO 13: Loop through all products

        // TODO 14: Print each product
        // Hint: System.out.println(product);

        for (Product product : items) {
            System.out.println(product);
        }

    }
}