package com.company.annotations.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String fullName;
    private String university;
    private int course;

    public void info(){
        System.out.println(this);
    }
}
