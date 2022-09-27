package com.company.test4;

public class Test4 {
    public static void main(String[] args) {
        Account account = new Account();

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setAccount(account);
        t2.setAccount(account);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main account.getBalance() = " + account.getBalance());

//        synchronized

    }
}

class MyThread extends Thread {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addToBalance(1);
        }
    }
}


class Account {
    private volatile double balance = 0;

    public void addToBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}