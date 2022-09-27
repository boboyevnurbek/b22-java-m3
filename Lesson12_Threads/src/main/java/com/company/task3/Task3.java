package com.company.task3;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    public static void main(String[] args) {
//   Homework - 1:     wait(), notify(), notifyAll()
//   Homework - 2:     package java.util.concurrent learning

//        Recommendation
//        1.
        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable runnable1 = () -> {
            for (int i = 0; i < 1000000; i++) {
                atomicInteger.incrementAndGet();
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main atomicInteger.intValue() = " + atomicInteger.intValue());


        // 2. not ArrayList => Vector or
        List<Integer> list = Collections.synchronizedList(List.of(10, 20));
    }
}
