package com.pluralsight.hotelapp.model;

public class Guest {

    private String name;
    private String phoneNumber;
    private String email;

    public Guest(String _name, String _phoneNumber, String _email) {
        this.name = _name;
        this.phoneNumber = _phoneNumber;
        this.email = _email;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this.phoneNumber = _phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public void displayGuestInfo() {
        System.out.println("Guest: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public void updateContactInfo(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

