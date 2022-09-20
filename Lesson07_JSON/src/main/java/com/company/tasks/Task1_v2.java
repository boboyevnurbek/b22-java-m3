package com.company.tasks;

import com.company.entity.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Task1_v2 {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
//            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?id=777");

            Post[] posts = mapper.readValue(url, Post[].class);

            System.out.println("posts.length = " + posts.length);

            for (Post post : posts) {
                System.out.println(post);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
