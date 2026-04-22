package com.pluralsight.workbook.iii.asychronous.payrollcalculator;

public class Employee {

    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int _id, String _name, double _hoursWorked, double _payRate) {
        this.id = _id;
        this.name = _name;
        this.hoursWorked = _hoursWorked;
        this.payRate = _payRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", payRate=" + payRate +
                '}';
    }
}
