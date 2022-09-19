package com.company.service;

import com.company.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        Student st = new Student("Ali", "Aliyev", 3, "PDP",
                List.of("Java", "Database", "Spring", "DSA"));
        System.out.println(st);

        List<Student> studentList =  new ArrayList<>();
        studentList.add(st);
        studentList.add(new Student("Otabek", "Eshpulatov", 2,
                "UZMU", List.of("Java", "Database", "Spring", "DSA")));
    }
}
