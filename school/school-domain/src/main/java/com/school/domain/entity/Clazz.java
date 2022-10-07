package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Clazz extends AbsEntity {

    private String name;
    private Teacher curator;

}
