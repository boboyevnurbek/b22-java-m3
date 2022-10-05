package com.company.annotations.examples;

import com.company.annotations.entity.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App1 {
    public static void main(String[] args) {
        // 1. get Car instance with newInstance() method
        // 2. set values powerHorse=800, model=Bugatti
        // 3. call info() method with reflection

        try {
            // solution 1
            Class<?> clazz = Class.forName("com.company.annotations.entity.Car");

            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();

            declaredConstructor.setAccessible(true);

            Object obj = declaredConstructor.newInstance();

            if(obj instanceof Car car){
                System.out.println(car);

                Field field = clazz.getDeclaredField("horsePower");
                field.setAccessible(true);
                field.set(car, 800);

                Method setMethod = clazz.getDeclaredMethod("setModel", String.class);
                setMethod.setAccessible(true);
                setMethod.invoke(car, "Bugatti");

                Method infoMethod = clazz.getDeclaredMethod("info");
                infoMethod.setAccessible(true);
                Object info = infoMethod.invoke(car);
                System.out.println(info);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
