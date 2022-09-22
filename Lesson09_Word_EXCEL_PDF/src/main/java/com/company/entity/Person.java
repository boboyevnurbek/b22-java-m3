package com.company.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String region;
    private String imageUrl;
}
