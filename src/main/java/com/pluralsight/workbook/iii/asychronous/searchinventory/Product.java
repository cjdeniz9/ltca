package com.pluralsight.workbook.iii.asychronous.searchinventory;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product(int _id, String _name, float _price) {
        this.id = _id;
        this.name = _name;
        this.price = _price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

}
