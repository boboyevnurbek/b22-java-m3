package com.company.annotations.entity;

import lombok.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ClassAnnotation
public class Student {

    private String fullName;
    private String university;
    private int course;

    @InfoAnnotation(number = -3)
    public void info(){
        System.out.println(this);
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassAnnotation{
}
