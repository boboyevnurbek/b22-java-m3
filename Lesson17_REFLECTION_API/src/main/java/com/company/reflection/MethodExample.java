package com.company.reflection;

import com.company.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodExample {
    public static void main(String[] args) {
        User user1 = new User("elbek", "pelbek", 18);

        Class<User> userClass = User.class;

        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println();

        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println();
            System.out.println("declaredMethod = " + declaredMethod);
            int modifiers = declaredMethod.getModifiers();

            System.out.println("modifiers = " + modifiers);
            System.out.println("Modifier.isPublic(modifiers) = " + Modifier.isPublic(modifiers));
            System.out.println("Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
            System.out.println("declaredMethod.getReturnType() = " + declaredMethod.getReturnType());

            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());

            System.out.println("declaredMethod.getParameterCount() = " + declaredMethod.getParameterCount());
            for (Class<?> parameterType : declaredMethod.getParameterTypes()) {
                System.out.println("parameterType = " + parameterType);
            }
        }


        System.out.println();

        try {
            Method method = userClass.getDeclaredMethod("aboutUser");
            method.setAccessible(true);
            method.invoke(user1);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        Class<? super User> superclass = userClass.getSuperclass();
        System.out.println("superclass = " + superclass);

        System.out.println("user1 = " + user1);

        // change password with reflection

        System.out.println("user1 = " + user1);

    }
}
