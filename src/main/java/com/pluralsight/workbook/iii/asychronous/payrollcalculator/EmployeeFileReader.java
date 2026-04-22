package com.pluralsight.workbook.iii.asychronous.payrollcalculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileReader {

    public List<Employee> readEmployeesFromCsv(String fileName) {
        List<Employee> employees = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream))){

            String line = bufReader.readLine();

            while ((line = bufReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length != 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = removeQuotes(parts[1]);
                double hoursWorked = Double.parseDouble(parts[2].trim());
                double payRate = Double.parseDouble(parts[3].trim());

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    public static String removeQuotes(String value) {
        return value.replace("\"", "").trim();
    }
}

