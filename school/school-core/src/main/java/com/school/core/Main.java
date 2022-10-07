package com.school.core;


import com.school.domain.entity.Subject;
import com.school.domain.service.SubjectService;

public class Main {

    static SubjectService subjectService = new SubjectService();

    public static void main(String[] args) {

        Subject subject = subjectService.addSubject("java");
        System.out.println("subject = " + subject);
    }
}
