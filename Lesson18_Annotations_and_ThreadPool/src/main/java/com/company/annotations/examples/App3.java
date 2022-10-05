package com.company.annotations.examples;

import com.company.annotations.entity.Book;
import com.company.annotations.entity.ImportantMethod;
import com.company.annotations.entity.ImportantString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App3 {
    public static void main(String[] args) {

        Book book = new Book("Java");

        Class<Book> clazz = Book.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        for (Field field : clazz.getDeclaredFields()) {
            ImportantString annotation = field.getAnnotation(ImportantString.class);
            System.out.println("annotation = " + annotation);
        }

        for (Method method : clazz.getDeclaredMethods()) {
            ImportantMethod[] annotationsByType = method.getAnnotationsByType(ImportantMethod.class);
            for (ImportantMethod importantMethod : annotationsByType) {
                method.setAccessible(true);
                try {
                    for (int i = 0; i < importantMethod.count(); i++) {
                        method.invoke(book);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
