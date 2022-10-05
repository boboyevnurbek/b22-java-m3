package com.company.gc;

import com.company.gc.entity.User;

public class App1 {
    public static void main(String[] args) {
        User user1 = new User("otabek");
        User user2 = new User("asror");

        System.out.println(user1);
        // user1 = user2;   // gc() user1 old reference
        // user1 = null;
        // new User();

        System.gc();
//        Runtime.getRuntime().gc();
    }
}
