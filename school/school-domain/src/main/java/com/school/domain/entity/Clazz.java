package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Clazz {
    private Integer id;
    private String name;
    private Teacher curator;
}
