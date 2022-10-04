package com.company.reflection;

import com.company.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class FieldExample {
    public static void main(String[] args) {

        User user1 = new User("elbek", "pelbek", 18);
        User user2 = new User("aziz", "paziz", 16);

        System.out.println("user1 = " + user1);

        Class<User> userClass = User.class;

        Field[] fields = userClass.getFields();
        System.out.println("fields = " + Arrays.toString(fields));

        System.out.println();
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
            System.out.println("declaredField.getName() = " + declaredField.getName());

            int modifiers = declaredField.getModifiers();
            System.out.println("modifiers = " + modifiers);
            System.out.println("Modifier.isPublic(modifiers) = " + Modifier.isPublic(modifiers));
            System.out.println("Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
            System.out.println("Modifier.isProtected(modifiers) = " + Modifier.isProtected(modifiers));
            System.out.println("Modifier.isAbstract(modifiers) = " + Modifier.isAbstract(modifiers));
            System.out.println("Modifier.isFinal(modifiers) = " + Modifier.isFinal(modifiers));
            System.out.println("\".....\" = " + ".....");

            System.out.println("declaredField.getType() = " + declaredField.getType());

            if (!Modifier.isPublic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }

            try {
                Object value = declaredField.get(user2);
                System.out.println("value = " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println();
        }


        System.out.println();
        try {
            Field field = userClass.getDeclaredField("username");
            field.setAccessible(true);
            Object username = field.get(user1);
            System.out.println("username = " + username);

            field.set(user1, "elbekjon");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

//        user1.username = "elbekjon";
//        user1.setUsername("elbekjon");

        System.out.println("\nuser1 = " + user1);
    }
}
