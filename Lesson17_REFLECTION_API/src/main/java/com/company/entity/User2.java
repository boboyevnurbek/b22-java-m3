package com.company.entity;

public class User2 extends Person {
    private String username;
    private String password;
    private int age;

//    public User2() {
//    }

    private User2(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
