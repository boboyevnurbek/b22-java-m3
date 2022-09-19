package com.company.tasks;

import com.company.entity.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        // Post larni array shaklida o'qib ekranga chiqarish
        // Post larni list shaklida o'qib ekranga chiqarish

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        File file = new File("src/main/resources/posts.json");

        try {

            Type type = new TypeToken<ArrayList<Post>>(){}.getType();

            ArrayList<Post> posts = gson.fromJson(new FileReader(file), type);

            for (Post post : posts) {
                System.out.println(post);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
