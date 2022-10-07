package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private Integer id;
    private String fullName;
    private Clazz clazz;
}
