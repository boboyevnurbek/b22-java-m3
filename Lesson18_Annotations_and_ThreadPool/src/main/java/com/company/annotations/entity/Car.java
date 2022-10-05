package com.company.annotations.entity;

import jdk.jfr.Description;

import java.lang.annotation.*;

@Description("This is describe for Car class")
@MyAnnotation
public class Car {
    @MyAnnotation
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

//@Target(ElementType.TYPE)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String info() default "this info annotation";
}