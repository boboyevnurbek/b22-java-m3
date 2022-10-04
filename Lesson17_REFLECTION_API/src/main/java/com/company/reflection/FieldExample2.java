package com.company.reflection;

import com.company.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class FieldExample2 {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("ali", "123", 18));
        System.out.println("users = " + users);

        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
//            Field field = arrayListClass.getDeclaredField("elementData");
            Field field = arrayListClass.getDeclaredField("DEFAULT_CAPACITY");
            System.out.println("field.getType() = " + field.getType());


            System.out.println("field.canAccess(users) = " + field.canAccess(users));
            field.setAccessible(true);

            Object obj = field.get(users);

            System.out.println("obj = " + obj);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
