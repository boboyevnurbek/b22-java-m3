package com.school.domain.entity;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Mark extends AbsEntity {

    private Student student;
    private Subject subject;
    private Integer point;
    private Integer year;
    private Teacher teacher;

}
