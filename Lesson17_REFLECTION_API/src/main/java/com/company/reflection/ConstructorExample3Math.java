package com.company.reflection;

import com.company.entity.User2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorExample3Math {
    public static void main(String[] args) {
        try {

            // EXCEPTION
            Class<?> clazz = Class.forName("java.lang.Math");

            Class[] params = {};

            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(params);

            declaredConstructor.setAccessible(true);

            Math math = (Math) declaredConstructor.newInstance();

            System.out.println("math = " + math);

        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | InvocationTargetException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
