package com.company.test1;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // Multiprocessing
        // Multithreading

//        System.out.println(10/0);

        // 1. extends Thread
        // 2. implements Runnable

        MyThread t1 = new MyThread();
        t1.setNum(100);
        t1.setName("Javohir");

        MyThread t2 = new MyThread();
        t2.setNum(10);
        t2.setName("Elbek");

        t1.setSubThread(t2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("MAIN FINISHED");

    }
}

class MyThread extends Thread {
    private MyThread subThread;

    private int num;

    public void setSubThread(MyThread subThread) {
        this.subThread = subThread;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        if(name.equals("Javohir")){
            try {
                subThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= num; i++) {
            System.out.println("i = " + i + " " + name);
            if (name.equals("Javohir")) {
                Thread.yield();
            }
        }
    }
}
