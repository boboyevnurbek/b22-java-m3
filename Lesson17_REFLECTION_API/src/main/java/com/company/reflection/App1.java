package com.company.reflection;

import com.company.entity.User;
import com.company.service.UserService;

public class App1 {
    public static void main(String[] args) {
        // Java Reflection API
        // package: java.lang.reflect.*

        // method - 1
        try {
            Class<?> aClass = Class.forName("com.company.entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // method - 2
        User user = new User();
        Class<? extends User> userClass = user.getClass();

        // method - 3
        Class<User> userClass1 = User.class;

        System.out.println("userClass1 = " + userClass1);

        Class<UserService> userServiceClass = UserService.class;
        System.out.println("userServiceClass = " + userServiceClass);

        System.out.println("userServiceClass.isInterface() = " + userServiceClass.isInterface());
        System.out.println("userServiceClass.isArray() = " + userServiceClass.isArray());

        System.out.println("int.class = " + int.class);
        System.out.println("void.class = " + void.class);

        System.out.println("User.class = " + User.class);

        System.out.println("UserService.class = " + UserService.class);

        System.out.println("int[].class = " + int[].class);
    }
}
