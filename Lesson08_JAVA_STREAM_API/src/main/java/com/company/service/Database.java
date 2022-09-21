package com.company.service;

import com.company.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    static List<Person> getPeople(){
        List<Person> people = new ArrayList<>();

        people.add(new Person("Javohir", "Orifkonov", 18, "Fergana", 200));
        people.add(new Person("Shaxzod", "Ismatov", 21, "Bukhara", 175));
        people.add(new Person("Madina", "Utkirbekova", 22, "Tashkent", 0));
        people.add(new Person("Nodira", "Shoraxmedova", 19, "Tashkent", 300));
        people.add(new Person("Mirsaid", "Karimullayev", 19, "Tashkent", 1800));
        people.add(new Person("Fotihjon", "Komilov", 18, "Tashkent", 5600));
        people.add(new Person("Murod", "Komilov", 22, "Xorazm", 150));
        people.add(new Person("Fayzullo", "Yusupov", 20, "Andijan", 100));
        people.add(new Person("Fayzullo", "Qaxramonov", 18, "Andijan", 100));

        return people;
    }
}
