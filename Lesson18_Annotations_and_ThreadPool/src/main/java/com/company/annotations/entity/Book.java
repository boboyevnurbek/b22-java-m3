package com.company.annotations.entity;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ImportantBook(info = "this is book class")
@InnerAnn(value = "inner 1")
@InnerAnn(value = "inner 2")
public class Book {
    @ImportantString
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @ImportantMethod(count = 5)
    @ImportantMethod(count = 6)
    private void getTitle(){
        System.out.println("title = " + title);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface WrapperAnn{
    InnerAnn[] value();
}

@Repeatable(value = WrapperAnn.class)
@interface InnerAnn{
    String value();
}
