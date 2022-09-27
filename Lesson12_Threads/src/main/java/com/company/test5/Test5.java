package com.company.test5;

public class Test5 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main Account.getBalance() = " + Account.getBalance());

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        synchronized (Account.class){
            for (int i = 0; i < 100; i++) {
                Account.addToBalance(1);
            }
        }
    }
}


class Account {
    private static double balance = 0;

//    public static synchronized void addToBalance(double amount) {
//            double b = balance;
//            b = b + amount;
//            balance = b;
//    }

    public static void addToBalance(double amount) {
        double b = balance;
        b = b + amount;
        balance = b;
    }

    public static double getBalance() {
        return balance;
    }
}