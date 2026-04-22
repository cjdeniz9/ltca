package com.pluralsight.workbook.iii.asychronous.payrollcalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        List<Employee> employees = manager.handleFileReader();

        for (Employee employee : employees) {
            manager.addEmployee(employee);
        }

        manager.handleFileWriter();
    }


}
