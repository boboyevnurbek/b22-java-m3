package com.school.domain.payload;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result {
    private String message;
    private boolean success;
}
