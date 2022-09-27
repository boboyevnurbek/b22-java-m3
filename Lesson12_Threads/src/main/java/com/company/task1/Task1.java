package com.company.task1;

public class Task1 {
    public static void main(String[] args) {
        // 1. Task1 va Task2 nomli 2 ta thread ochish
        // 2. run() da har bir thread o'z nomini 10 martadan ekranga chiqaradi
        // 3. "task1" thread  "task2" threadni kutishi kerak

        MyThread task1 = new MyThread();
        task1.setName("task1");

        MyThread task2 = new MyThread();
        task2.setName("task2");

        task1.setSubThread(task2);
        //task2.setSubThread(task1);

        task1.start();
        task2.start();
    }
}

class MyThread extends Thread {
    private MyThread subThread;

    public void setSubThread(MyThread subThread) {
        this.subThread = subThread;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        if (name.equals("task1")) {
            try {
                subThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ") " + name);

        }
    }
}

