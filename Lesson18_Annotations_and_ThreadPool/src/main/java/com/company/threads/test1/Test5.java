package com.company.threads.test1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test5 {
    public static void main(String[] args) {
//        Executors, ExecutorService

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            System.out.println("begin");
            System.out.println("\r"+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\r"+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            System.out.println("end");
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);
    }
}
