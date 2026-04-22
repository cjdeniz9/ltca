package com.pluralsight.workbook.iii.asychronous.payrollcalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {

    Scanner scanner = new Scanner(System.in);

    private final List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println("=== EMPLOYEE ===");
            System.out.println("id: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.printf("Gross pay: $%.2f%n", employee.getGrossPay());
            System.out.println();
        }
    }

    public List<Employee> handleFileReader() {
        System.out.print("Enter the name of the file employee file to process: ");
        String inputReadPath = scanner.nextLine();

        EmployeeFileReader fileReader = new EmployeeFileReader();

        return fileReader.readEmployeesFromCsv("workbook/iii/asychronous/" + inputReadPath);
    }

    public void handleFileWriter() {
        System.out.print("Enter the name of the payroll file to create: ");
        String inputWritePath = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/main/resources/workbook/iii/asychronous/" + inputWritePath)) {
            writer.write(inputWritePath.toLowerCase().endsWith(".json") ? "[\n" : "");

            System.out.println();
            System.out.println("Creating file..");

            for (Employee employee : employees) {
                if (inputWritePath.toLowerCase().endsWith(".csv")) {
                    writer.write(employee.getId() + "|" + employee.getName() + "|" + employee.getGrossPay() + "\n");
                } else if (inputWritePath.toLowerCase().endsWith(".json")) {
                    writer.write(String.format(
                            "  {\"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f},\n",
                            employee.getId(), employee.getName(), employee.getGrossPay()
                    ));
                }
            }

            writer.write(inputWritePath.toLowerCase().endsWith(".json") ? "]" : "");

            delay(1000);
            System.out.println("Filed created!");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
