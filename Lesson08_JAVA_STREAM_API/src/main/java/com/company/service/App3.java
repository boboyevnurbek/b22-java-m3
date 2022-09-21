package com.company.service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                List.of(25, 47, 84, 15, 24, 71, 3, 15, 21, 99, 84, 99, 100));
        System.out.println("list = " + list);

        boolean allMatch = list.stream().allMatch(n -> (n >= 60));
        System.out.println("allMatch = " + allMatch);

        boolean anyMatch = list.stream().anyMatch(n -> (n == 100));
        System.out.println("anyMatch = " + anyMatch);

        boolean noneMatch = list.stream().noneMatch(n -> (n < 60));
        System.out.println("noneMatch = " + noneMatch);


        long count = list.stream()
                .filter(n -> n >= 60).count();
        System.out.println("count = " + count);

        List<Integer> list1 = list.stream()
                .filter(n -> n >= 60).collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        Set<Integer> set1 = list.stream()
                .filter(n -> n >= 60).collect(Collectors.toSet());
        System.out.println("set1 = " + set1);

        List<Integer> list2 = list.stream().toList();
        System.out.println("list2 = " + list2);
        List<Integer> list3 = list.stream().distinct().toList();
        System.out.println("list3 = " + list3);


        Optional<Integer> optional = list.stream().filter(n -> n >= 60).findFirst();
        System.out.println("optional = " + optional);
        if (optional.isPresent()) {
            System.out.println("optional.get() = " + optional.get());
        }

        List<Integer> sortedList = list.stream()
                .sorted(Collections.reverseOrder()).toList();
        System.out.println("sortedList = " + sortedList);

        List<Integer> grands = list.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .toList();

        System.out.println("grands = " + grands);

        List<Integer> contracts = list.stream()
                .sorted(Collections.reverseOrder())
                .skip(3)
                .limit(4)
                .toList();

        System.out.println("contracts = " + contracts);

        List<Integer> doubleList = Stream.generate(() -> new Random().nextInt(100))
                .limit(10).toList();
        System.out.println(doubleList);

        System.out.println(Stream.iterate(3, n -> n * 2).limit(10).toList());

        List<Integer> items = Stream.iterate(1, p -> p * 2)
                .peek(item -> System.out.println("Item : " + item))
                .limit(7)
                .toList();
        System.out.println("items = " + items);

        Optional<Integer> maxOptional = list.stream().max(Integer::compareTo);
        System.out.println("maxOptional.get() = " + maxOptional.get());

        Optional<Integer> minOptional = list.stream().min(Integer::compareTo);
        System.out.println("minOptional.get() = " + minOptional.get());

        Optional<Integer> reduceOptional = list.stream().reduce((total, element) -> total + element);
        System.out.println("reduceOptional = " + reduceOptional);
        System.out.println("reduceOptional.get() = " + reduceOptional.get());

        Integer reduce = list.stream().reduce(0, (total, element) -> total + element);
        System.out.println("reduce = " + reduce);

        Integer integer = list.stream().filter(n -> n >= 10).findFirst().orElse(null);
        System.out.println("integer = " + integer);


    }


}
