package com.company.service;

import com.company.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    static List<Person> getPeople(){
        List<Person> people = new ArrayList<>();

        people.add(new Person("Javohir", "Orifkonov", 18, "Fergana", 200, List.of("uzbek", "english", "german")));
        people.add(new Person("Shaxzod", "Ismatov", 21, "Bukhara", 175, List.of("uzbek", "english", "turkish")));
        people.add(new Person("Madina", "Utkirbekova", 22, "Tashkent", 0, List.of("uzbek", "english")));
        people.add(new Person("Nodira", "Shoraxmedova", 19, "Tashkent", 300, List.of("uzbek", "english")));
        people.add(new Person("Mirsaid", "Karimullayev", 19, "Tashkent", 1800, List.of("uzbek", "english", "arabic")));
        people.add(new Person("Fotihjon", "Komilov", 18, "Tashkent", 5600, List.of("uzbek", "english", "japanese")));
        people.add(new Person("Murod", "Komilov", 22, "Xorazm", 150, List.of("uzbek", "english")));
        people.add(new Person("Fayzullo", "Yusupov", 20, "Andijan", 100, List.of("uzbek", "english", "spanish")));
        people.add(new Person("Fayzullo", "Qaxramonov", 18, "Andijan", 100, List.of("uzbek", "english", "russian")));

        return people;
    }
}
