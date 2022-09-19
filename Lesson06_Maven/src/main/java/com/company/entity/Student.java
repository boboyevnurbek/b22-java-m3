package com.company.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString(exclude = {"name", "course"})
@ToString
public class Student {
    private String name;
    private String surname;
    private int course = 1;
    private String university;
    private List<String> subjects;

    public Student(String name, String surname, String university, List<String> subjects) {
        this.name = name;
        this.surname = surname;
        this.university = university;
        this.subjects = subjects;
    }
}
