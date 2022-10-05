package com.company.annotations.entity;

import java.lang.annotation.*;

@Repeatable(value = WrapperImportantMethod.class)
public @interface ImportantMethod {
    int count() default 1;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface WrapperImportantMethod{
    ImportantMethod[] value();
}
