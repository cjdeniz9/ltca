package com.pluralsight.workbook.iv.sychronous;

public class Dog {

    private final String name;
    private final String breed;
    private int age;

    public Dog(String _name, String _breed, int _age) {
        this.name = _name;
        this.breed = _breed;
        this.age = _age;
    }

    public void feed() {
        System.out.println(this.name + "has been fed");
    }

    public void walk() {
        System.out.println("Taking " + this.name + " for a walk" );
    }

}
