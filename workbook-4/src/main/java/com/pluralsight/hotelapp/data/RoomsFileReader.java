package com.pluralsight.hotelapp.data;

import com.pluralsight.hotelapp.model.Room;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoomsFileReader {

    public List<Room> readRoomsFromJson() {

        try {
            ObjectMapper mapper = new ObjectMapper();

            return Arrays.asList(
                    mapper.readValue(
                            new File("/Users/cjdeniz/Documents/projects/ltca/workbook-iv/data/rooms.json"),
                            Room[].class
                    )
            );

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

            return Collections.emptyList();
        }

    }
}
