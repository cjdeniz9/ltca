package com.pluralsight.workbook.iii.sychronous.amazon;

import com.pluralsight.workbook.iii.sychronous.amazon.model.Cart;
import com.pluralsight.workbook.iii.sychronous.amazon.model.Product;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> storeProducts = new ArrayList<>();

        storeProducts.add(new Product("Laptop", 1000));
        storeProducts.add(new Product("Mouse", 50));
        storeProducts.add(new Product("Keyboard", 150));
        storeProducts.add(new Product("Monitor", 300));

        System.out.println("Available store products:");

        for (Product product : storeProducts) {
            System.out.println(product);
        }

        System.out.println();System.out.println("================================");
        System.out.println();

        Cart cart = new Cart();

        cart.addProduct(storeProducts.get(0));
        cart.addProduct(storeProducts.get(1));
        cart.addProduct(storeProducts.get(2));
        System.out.println("Cart items:");

        for (Product product : cart.getItems()) {
            System.out.println(product);
        }

        System.out.println("------------------");
        System.out.printf("Total: $%.2f%n", cart.getTotalPrice());
        System.out.println();System.out.println("Item count: " + cart.getItemCount());

    }
}
