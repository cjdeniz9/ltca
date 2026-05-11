package com.pluralsight.hotelapp;

import com.pluralsight.hotelapp.data.RoomsFileReader;
import com.pluralsight.hotelapp.model.*;
import com.pluralsight.hotelapp.ui.UserInterface;

import java.util.List;

// page 46

public class Main {

    public static void main(String[] args) {

        RoomsFileReader roomsFileReader = new RoomsFileReader();

        List<Room> rooms = roomsFileReader.readRoomsFromJson();

        for (Room room : rooms) {
            System.out.println(room);
        }

//        UserInterface ui = new UserInterface();
//        ui.start();

    }

}
