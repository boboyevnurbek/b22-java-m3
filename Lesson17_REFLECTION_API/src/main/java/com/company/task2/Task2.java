package com.company.task2;

public class Task2 {
    public static void main(String[] args) {
        // Reflection API orqali uchchala metodni ham chaqirish
    }
}

class Calculator{
    private int add(int a, int b){
        return a+b;
    }
    private String add(String a, int b){
        return a+b;
    }

    private String add(String a, String b){
        return a+b;
    }
}
