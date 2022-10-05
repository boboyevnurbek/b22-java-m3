package com.company.threads.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    static  int i = 0;
    public static void main(String[] args) {
//        Executors, ExecutorService

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(() -> System.out.println("1 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("2 in "+Thread.currentThread().getName()));
        service.execute(() -> {
            try {
                Thread.sleep(61000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3 in "+Thread.currentThread().getName());
        });
        service.execute(() -> System.out.println("4 in "+Thread.currentThread().getName()));
        service.execute(() -> System.out.println("5 in "+Thread.currentThread().getName()));

        service.shutdown();
    }
}
