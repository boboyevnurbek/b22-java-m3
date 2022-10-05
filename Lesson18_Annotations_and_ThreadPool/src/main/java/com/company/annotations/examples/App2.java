package com.company.annotations.examples;

import com.company.annotations.entity.Car;
import jdk.jfr.Description;
import jdk.jfr.Name;

import java.lang.annotation.Annotation;

//@Override
//@FunctionalInterface
//@Name()
//@Description()
public class App2 {
    public static void main(String[] args) {
        Class<Car> clazz = Car.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println();
            System.out.println(annotation);
        }
    }
}
