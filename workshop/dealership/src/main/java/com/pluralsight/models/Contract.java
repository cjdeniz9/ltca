package com.pluralsight.models;

public abstract class Contract {

     protected String dateOfContact;
     protected String customerName;
     protected String customerEmail;
     protected Vehicle vehicleSold;

    public Contract(String dateOfContact, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.dateOfContact = dateOfContact;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDateOfContact() {
        return dateOfContact;
    }

    public void setDateOfContact(String dateOfContact) {
        this.dateOfContact = dateOfContact;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    protected abstract double getTotalPrice();

    protected abstract double getMonthlyPayment();

    protected abstract String toCsvLine();

}
