package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student extends AbsEntity{

    private String fullName;
    private Clazz clazz;

}
