package com.company.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private double price;
}
