package com.school.core;


import com.school.domain.entity.Subject;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setId(1);
        subject.setName("Programming");
        System.out.println("subject = " + subject);
    }
}
