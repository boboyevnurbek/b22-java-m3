package com.company.gc;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("before runtime.totalMemory() = " + runtime.totalMemory()+"\n");

        double freeMemory = runtime.freeMemory() / 1024. / 1024;
        System.out.println("before runtime.freeMemory() = " + freeMemory+" MB");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        double totalMemory = runtime.totalMemory() / 1024. / 1024;
        System.out.println("before runtime.totalMemory() = " + totalMemory+" MB");

        freeMemory = runtime.freeMemory() / 1024. / 1024;
        System.out.println("after runtime.freeMemory() = " + freeMemory+ " MB");


        System.out.println();

        list = null;
        System.gc();

        for (int i = 0; true; i++) {
            totalMemory = runtime.totalMemory() / 1024. / 1024;
            System.out.println(i+" totalMemory() = " + totalMemory+" MB");
            if(totalMemory < 100) break;
        }

        totalMemory = runtime.totalMemory() / 1024. / 1024;
        System.out.println("before runtime.totalMemory() = " + totalMemory+" MB");

        freeMemory = runtime.freeMemory() / 1024. / 1024;
        System.out.println("after runtime.freeMemory() = " + freeMemory+ " MB");
    }
}
