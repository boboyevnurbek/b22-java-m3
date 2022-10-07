package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Mark {
    private final Integer id;
    private Student student;
    private Subject subject;
    private Integer point;
    private Integer year;
    private Teacher teacher;
}
