package com.company.service;

import com.company.entity.Geo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App2 {

    static final String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(BASE_FOLDER, "geo.json");

        try {

            Geo geo = mapper.readValue(file, Geo.class);
            System.out.println(geo);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
