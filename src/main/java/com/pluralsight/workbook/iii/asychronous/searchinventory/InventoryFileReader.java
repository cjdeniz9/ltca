package com.pluralsight.workbook.iii.asychronous.searchinventory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InventoryFileReader {

    public List<Product> readInventoryFromCsv (String fileName) {
        List<Product> inventory = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = bufReader.readLine();

            while ((line = bufReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length != 3) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name =  removeQuotes(parts[1]);
                float price = Float.parseFloat(parts[2].trim());

                Product product = new Product(id, name, price);
                inventory.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inventory;
    }

    public static String removeQuotes(String value) {
        return value.replace("\"", "").trim();
    }
}
