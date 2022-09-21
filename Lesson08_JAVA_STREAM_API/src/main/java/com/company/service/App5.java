package com.company.service;

import com.company.entity.Person;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App5 {
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>(
//                List.of(25, 47, 84, 15, 24, 71, 3, 15, 21, 99, 84, 99, 100));
//
//        Stream<Integer> stream = list.stream();
//
//        stream.toList().forEach(System.out::println);
//        stream.toList().forEach(System.out::println); // exception

        double average = IntStream.generate(() -> new Random().nextInt(100))
                .peek(System.out::println)
                .limit(10)
                .summaryStatistics()
                .getAverage();

        System.out.println("average = " + average);

//        IntStream intStream = IntStream.generate(() -> new Random().nextInt(100))
//                .peek(System.out::println)
//                .limit(10);
//
//        int[] array = intStream.toArray();
//        System.out.println("array = " + Arrays.toString(array));
//
//        IntSummaryStatistics statistics = intStream.summaryStatistics();
//        System.out.println("statistics.getMin() = " + statistics.getMin());
//        System.out.println("statistics.getMax() = " + statistics.getMax());
//        System.out.println("statistics.getCount() = " + statistics.getCount());
//        System.out.println("statistics.getSum() = " + statistics.getSum());
//        System.out.println("statistics.getAverage() = " + statistics.getAverage());

    }
}
