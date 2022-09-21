package com.company.service;

import com.company.entity.Person;

import java.util.*;
import java.util.stream.Collectors;

public class App4 {
    public static void main(String[] args) {
        List<Person> people = Database.getPeople();

        System.out.println("\n **** sorted ***");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getBalance))
                .toList()
                .forEach(System.out::println);

        System.out.println("\n **** map ***");

        people.stream()
                .map(Person::getAge)
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);

        System.out.println("\n **** map, max balance ***");

        System.out.println(people.stream()
                .map(Person::getBalance)
                .max(Double::compareTo)
                .orElse(0d));

        System.out.println("\n **** group by ***");
//        Map<String, List<Person>> map = new HashMap<>();
//        for (Person person : people) {
//            map.merge(person.getRegion(), new ArrayList<>(List.of(person)), (p1, p2) -> {
//                p1.addAll(p2);
//                return p1;
//            });
//        }
//
//        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//            System.out.println();
//        }

        Map<String, List<Person>> listMap = people.stream()
                .collect(Collectors.groupingBy(Person::getRegion));

        listMap.forEach((region, personList) -> {
            System.out.println(region);
            personList.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("\n **** flatMap ***");

        people.stream()
                .flatMap(person -> person.getLanguages().stream())
                .distinct()
                .sorted()
                .toList()
                .forEach(System.out::println);
    }
}
