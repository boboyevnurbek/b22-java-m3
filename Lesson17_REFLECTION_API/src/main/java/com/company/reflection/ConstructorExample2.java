package com.company.reflection;

import com.company.entity.User2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Calendar;

public class ConstructorExample2 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.company.entity.User2");
//            User2 user = (User2) clazz.newInstance();

            Class[] params = {String.class, String.class, int.class};

            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(params);

            declaredConstructor.setAccessible(true);

            User2 user = (User2) declaredConstructor.newInstance("ali", "123", 20);

            System.out.println("user = " + user);

        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | InvocationTargetException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
