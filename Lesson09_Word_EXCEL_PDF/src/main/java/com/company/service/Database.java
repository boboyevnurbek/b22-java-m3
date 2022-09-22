package com.company.service;

import com.company.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface Database {

    String BASE_FOLDER = "src/main/resources/files/images";
    static List<Person> getPeople(){
        List<Person> people = new ArrayList<>();

        people.add(new Person("Javohir", "Orifkonov", 18, "Fergana",
                BASE_FOLDER+"/javohir.jpg"));
        people.add(new Person("Shaxzod", "Ismatov", 21, "Bukhara",
                BASE_FOLDER+"/shaxzod.jpg"));
        people.add(new Person("Mirsaid", "Karimullayev", 19, "Tashkent",
                BASE_FOLDER+"/mirsaid.jpg"));
        people.add(new Person("Fotihjon", "Komilov", 18, "Tashkent",
                BASE_FOLDER+"/fotih.jpg"));
        people.add(new Person("Murod", "Komilov", 22, "Xorazm",
                BASE_FOLDER+"/murod.jpg"));
        people.add(new Person("Fayzullo", "Yusupov", 20, "Andijan",
                BASE_FOLDER+"/fayzullo2.jpg"));
        people.add(new Person("Fayzullo", "Qaxramonov", 18, "Andijan",
                BASE_FOLDER+"/fayzullo1.jpg"));

        return people;
    }
}
