package com.pluralsight.aiornotai.ui;

import com.pluralsight.aiornotai.models.Multimedia;

import java.util.List;

public class UserInterface {

    public void displayHeader() {
        System.out.println("""
            =================================
                A I   O R   N O T   A I
            =================================
              Fake AI Detection Console App
            =================================
            """);
    }

    public void displayFiles(List<Multimedia> files) {
        for (Multimedia file : files) {
            displayFile(file);
        }
    }

    private void displayFile(Multimedia file) {
        System.out.println(file);
        System.out.println();
    }
}