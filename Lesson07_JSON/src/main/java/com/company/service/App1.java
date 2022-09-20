package com.company.service;

import com.company.entity.Geo;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App1 {

    static final String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(BASE_FOLDER, "geo.json");

        Geo geo = new Geo("Uzbekistan", "Tashkent");

        try {
            mapper.writeValue(file, geo);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
