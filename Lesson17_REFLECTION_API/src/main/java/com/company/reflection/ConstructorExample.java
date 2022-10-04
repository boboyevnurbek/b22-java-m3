package com.company.reflection;

import com.company.entity.User2;

import java.lang.reflect.Constructor;

public class ConstructorExample {
    public static void main(String[] args) {
        Class<User2> clazz = User2.class;

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
    }
}
