package com.company.annotations.entity;

public class Car {
    private int horsePower;
    private String model;

    private Car() {}

    private int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private String info(){
        return getModel()+" -> "+getHorsePower();
    }
}
