package com.school.domain.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "teacherList")
public class Subject extends AbsEntity {

    private String name;
    private List<Teacher> teacherList;

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
