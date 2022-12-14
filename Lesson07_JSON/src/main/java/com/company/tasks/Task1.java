package com.company.tasks;

import com.company.entity.Post;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Task1 {
    static final String BASE_FOLDER="src/main/resources";

    public static void main(String[] args) {
        File file =new File(BASE_FOLDER,"posts.json");
        ObjectMapper mapper=new ObjectMapper();

        try {
            Post[] posts = mapper.readValue(file, Post[].class);

            for (Post post : posts) {
                System.out.println(post);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
