package com.school.domain.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Teacher extends AbsEntity {

    private String fullName;
    private List<Subject> subjectList;

}
