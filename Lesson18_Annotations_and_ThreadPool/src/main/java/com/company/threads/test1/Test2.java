package com.company.threads.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
//        Executors, ExecutorService

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(() -> System.out.println("1 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("2 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("3 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("4 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("5 in "+Thread.currentThread().getName()));

        service.shutdown();
    }
}
