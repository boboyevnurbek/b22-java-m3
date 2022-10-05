package com.company.gc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;

    @Override
    public void finalize() throws Throwable {
        System.out.println(username+" outside from game");
    }
}
