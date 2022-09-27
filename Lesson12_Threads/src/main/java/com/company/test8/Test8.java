package com.company.test8;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8 {

    static List<User> users = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();
        Auth auth = new Auth();

        Runnable runnable = () -> {
            for (int i = 0; i < 50; i++) {
                String username = faker.address().country();
                String password = "123";
                User register = auth.register(username, password);
                System.out.println(register);
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("*****");
        System.out.println("users.size() = " + users.size());
        users.forEach(System.out::println);
        System.out.println("#####");

        for (User user : users) {
            int counter = 0;
            for (User user1 : users) {
                if(user.getUsername().equals(user1.getUsername())){
                    counter++;
                }
            }
            if(counter > 1){
                System.out.println("user.getUsername() = " + user.getUsername());
                System.out.println("counter = " + counter);
            }
        }
    }
}

class Auth {
    public synchronized User register(String username, String password) {
        for (User user : Test8.users) {
            if(user.getUsername().equals(username)){
                return null;
            }
        }

        User user = new User(username, password);
        Test8.users.add(user);
        return user;
    }
}


class User {
    private String username; // unique
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
