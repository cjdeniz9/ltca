package com.pluralsight.hotelapp.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Employee {

    private int employeeId;
    private String name;
    private String role;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int _employeeId, String _name, String _role, String _department, double _payRate, double _hoursWorked) {
        this.employeeId = _employeeId;
        this.name = _name;
        this.role = _role;
        this.department = _department;
        this.payRate = _payRate;
        this.hoursWorked = _hoursWorked;
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

    public LocalDateTime punchTimeCardNow() {
        return LocalDateTime.now();
    }

    public void displayEmployeeInfo() {
        System.out.println("""
            Employee ID: %d
            Name: %s
            Department: %s
            Role: %s

            Pay rate: $%.2f   
            Regular hours: %.2f
            Overtime hours: %.2f
            Total pay: $%.2f
            """.formatted(
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
