package com.company.annotations.examples;

import com.company.annotations.entity.InfoAnnotation;
import com.company.annotations.entity.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App4 {
    public static void main(String[] args) {
        // 1. create annotation for class with named 'ClassAnnotation'
        // 2. create annotation for info() method with named 'InfoAnnotation(number=3)'
        // 3. invoke info() method by number InfoAnnotation

        // 12 minutes

        Student student = new Student("Otabek", "IT PARK UNIVERSITY", 1);

        Annotation[] annotations = Student.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        for (Method method : Student.class.getDeclaredMethods()) {
            InfoAnnotation[] infoAnnotations = method.getAnnotationsByType(InfoAnnotation.class);
            for (InfoAnnotation annotation : infoAnnotations) {
                System.out.println(annotation);
                for (int i = 0; i < annotation.number(); i++) {
                    try {
                        method.invoke(student);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
