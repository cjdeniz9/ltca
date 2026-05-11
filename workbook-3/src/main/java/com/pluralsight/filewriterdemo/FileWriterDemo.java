package com.pluralsight.workbook.iii.sychronous;

import java.io.FileWriter;
import java.io.IOException;

public class i {
    public static void main(String[] args) throws Exception{
        //Creating the object that has the ability to write to files
//        FileWriter writer = new FileWriter("src/main/resources/workbook/iii/sychronous/christian.txt", true);
//        writer.append("Hello this new from Yearup\n");
//        writer.append("Good a new line");
//        writer.close();

        // To stop memory leakage .
//        StringBuilder aLongerListOfData = new StringBuilder();
//        aLongerListOfData.append("This is the first part");
//        aLongerListOfData.append("Second part of the text");

        try (FileWriter writer = new FileWriter("src/main/resources/workbook/iii/sychronous/christian.txt", true)) {
            writer.write("Hello from try-with-resources\n");
            writer.write("Another line");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}