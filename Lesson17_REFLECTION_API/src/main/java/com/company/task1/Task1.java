package com.company.task1;

public class Task1 {
    public static void main(String[] args) {
        // 1. newInstance orqali 3 ta konstructordan ham object olish
        // 2. car haqidagi malumotni info() ni chaqirish
        // orqali ekranga chiqaish
    }
}

class Car{
    private String model;
    private double price;

    private Car() {
    }

    private Car(String model) {
        this.model = model;
    }

    private Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    private String info(){
        return model+" -> "+price;
    }
}
