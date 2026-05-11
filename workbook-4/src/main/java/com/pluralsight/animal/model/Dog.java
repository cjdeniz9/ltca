package com.pluralsight.animal.model;

// The dog is a Child-class (a.k.a. subclass from Animal)
public class Dog extends Animal  {

    public Dog(String _name) {
        super(_name); //Calls animal constructor
//        this.setName(_name);
    }

    //Polymorphisme (many forms)
    @Override
    public void makeSound() {
        System.out.println(getName() + "woef woef");
    }
}
