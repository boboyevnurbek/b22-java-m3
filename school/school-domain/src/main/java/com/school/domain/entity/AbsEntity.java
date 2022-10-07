package com.school.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbsEntity {

    protected Integer id;
    protected boolean deleted;

}
