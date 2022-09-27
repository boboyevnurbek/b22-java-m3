package com.company.test2;

public class Test2 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setName("javohir");
        t1.setPriority(8);

        MyThread2 t2 = new MyThread2(t1);
        t2.setName("elbek");
        t2.setPriority(10);

        t2.start();
        t1.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        System.out.println(name+ " \t priority = "+priority);
    }
}

class MyThread2 extends Thread{

    private Thread thread;

    public MyThread2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String name = Thread.currentThread().getName();
        System.out.println("name = "+ name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int priority = Thread.currentThread().getPriority();
        System.out.println(name+ " \t priority = "+priority);
    }
}
