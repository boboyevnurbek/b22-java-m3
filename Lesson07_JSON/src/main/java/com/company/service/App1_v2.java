package com.company.service;

import com.company.entity.Geo;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App1_v2 {

    static final String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(BASE_FOLDER, "geo2.json");

        Geo geo = new Geo("Uzbekistan", "Tashkent");

        try {
           //mapper.writerWithDefaultPrettyPrinter().writeValue(file, geo);
           mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(file, true), geo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
