package com.pluralsight.hotelapp.service;

import com.pluralsight.hotelapp.model.Employee;

public class EmployeeService {

    public void displayEmployeeInfo(Employee employee) {
        employee.displayEmployeeInfo();
    }

    public void assignRole(Employee employee, String newRole) {
        employee.assignRole(newRole);
        System.out.println("Employee role updated to: " + newRole);
    }
}
