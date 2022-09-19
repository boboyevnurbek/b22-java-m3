package com.company.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
