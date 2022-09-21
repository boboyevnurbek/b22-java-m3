package com.company.service;

import com.company.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App2 {
    public static void main(String[] args) {
        List<Person> people = Database.getPeople();

        //        Imperative
        List<Person> res1 = new ArrayList<>();
        for (Person person : people) {
            if(person.getAge()==18){
                res1.add(person);
            }
        }
        res1.forEach(System.out::println);

        System.out.println("*************");
        //        Declarative
        List<Person> res2 = people.stream()
                .filter(person -> person.getAge() == 18)
                .toList();
        res2.forEach(System.out::println);

    }
}
