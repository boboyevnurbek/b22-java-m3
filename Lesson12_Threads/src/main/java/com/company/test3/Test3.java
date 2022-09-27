package com.company.test3;

public class Test3 {
    public static void main(String[] args)  {
        Thread thread = new Thread(new MyThread());
        thread.interrupt();

        thread.start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(i+") "+name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("meni bezovta qilishdi");
            }
        }
    }
}
