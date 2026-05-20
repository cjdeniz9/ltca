package com.pluralsight.aiornotai;

import com.pluralsight.aiornotai.data.DemoDataFactory;
import com.pluralsight.aiornotai.models.Multimedia;
import com.pluralsight.aiornotai.ui.UserInterface;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DemoDataFactory demoDataFactory = new DemoDataFactory();
        UserInterface ui = new UserInterface();

        List<Multimedia> files = demoDataFactory.createDemoFiles();

        ui.displayHeader();
        ui.displayFiles(files);

    }
}
