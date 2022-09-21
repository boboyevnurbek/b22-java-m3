package com.company.service;

import com.company.entity.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class App6 {
    public static void main(String[] args) {

        List<Person> people = Database.getPeople();

        // 1. Katta yoshli personlarni barchasini chiqarish
        System.out.println("\n *** 1 ***");

        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::getAge));

        people.stream()
                .filter(person -> person.getAge() == max.get().getAge())
                .toList()
                .forEach(System.out::println);


        // 2. Barcha person larning umumiy balansini aniqlash
        System.out.println("\n *** 2 ***");
        double sum = people.stream()
                .mapToDouble(Person::getBalance)
                .summaryStatistics()
                .getSum();
        System.out.println("sum = " + sum);


        // 3. Yosh bo'yicha personlarni guruhlarga ajratish
        System.out.println("\n *** 3 ***");
        Map<Integer, List<Person>> collect = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        for (Map.Entry<Integer, List<Person>> entry : collect.entrySet()) {
            System.out.println("\nage = "+entry.getKey());
            entry.getValue().forEach(System.out::println);
        }

        // 4. Ingliz tilini biladigan personlarni chiqarish
        System.out.println("\n *** 4 ***");
        people.stream()
                .filter(person -> person.getLanguages().contains("english"))
                .forEach(System.out::println);

        // 5. Balansi 200 dan 1000 gacha oraliqdagi personlarni
        // o'rtacha balansini chiqarish

        double averageBalance200And1000 = people.stream()
                .map(Person::getBalance)
                .filter(val -> (val >= 200 && val <= 1000))
                .mapToDouble(value -> value)
                .summaryStatistics()
                .getAverage();

        System.out.println("averageBalance200And1000 = " + averageBalance200And1000);

    }
}
