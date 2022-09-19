package com.company.service;

import com.company.entity.Car;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedList;

public class App5 {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls().create();

//        Car car = new Car("Malibu", 2000d, "01A001AA");
//
//        String json = gson.toJson(car);
//
//        System.out.println(json);

        String json = "{\n" +
                "  \"model\": \"Malibu\",\n" +
                "  \"price\": 2000.0,\n" +
                "  \"license plate\": \"01A001AA\"\n" +
                "}";

        Car car = gson.fromJson(json, Car.class);
        System.out.println(car);


    }
}
