package com.company.service;

import com.company.entity.Person;
import com.github.javafaker.Color;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class App1 {
    public static void main(String[] args) {

        Faker faker = new Faker();

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1500; i++) {
            people.add(new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(18, 45),
                    faker.address().city(),
                    faker.number().randomDouble(2, 0, 100),
                            List.of("english")
            ));
        }

        people.forEach(System.out::println);

//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//        System.out.println(faker.color().name());
//
//        System.out.println(faker.name().firstName());
//        System.out.println(faker.name().lastName());
//        System.out.println(faker.address().country());
//        System.out.println(faker.address().cityName());

    }
}
