package com.pluralsight.hotelapp.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Employee {

    private boolean isWorking;
    private int employeeId;
    private String name;
    private String role;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalDateTime clockedIn;

    public Employee(boolean isWorking, int employeeId, String name, String role, String department, double payRate, double hoursWorked, LocalDateTime clockedIn) {
        this.isWorking = isWorking;
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.clockedIn = clockedIn;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int _employeeId) {
        this.employeeId = _employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String _role) {
        this.role = _role;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public LocalDateTime getClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(LocalDateTime clockedIn) {
        this.clockedIn = clockedIn;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours () {
        return Math.max(hoursWorked - 40, 0);
    }

    public double getTotalPay() {
        double regularHours = getRegularHours();
        double overtimeHours = getOvertimeHours();

        double regularPay = payRate * regularHours;
        double overtimePay = (payRate * 1.5) * overtimeHours;

        return regularPay + overtimePay;
    }

    public double punchTimeCard(int punchInTime, int punchOutTime) {
        int hoursWorkedToday = Math.abs(punchInTime - punchOutTime);

        return hoursWorked + hoursWorkedToday;
    }

    public LocalDateTime punchTimeCard() {
        return LocalDateTime.now();
    }

    public void displayEmployeeInfo() {
        System.out.println("""
            Working: %b
            
            Employee ID: %d
            Name: %s
            Department: %s
            Role: %s

            Pay rate: $%.2f   
            Regular hours: %.2f
            Overtime hours: %.2f
            Total pay: $%.2f
            """.formatted(
                isWorking,
                employeeId,
                name,
                department,
                role,
                payRate,
                getRegularHours(),
                getOvertimeHours(),
                getTotalPay()
        ));
    }

    public void assignRole(String role) {
        this.role = role;
    }

}
