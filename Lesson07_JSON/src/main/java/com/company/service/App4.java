package com.company.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App4 {
    static final String BASE_FOLDER = "src/main/resources";
    public static void main(String[] args) {

        String fileName = BASE_FOLDER+"/posts.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            JSONArray jsonArray = new JSONArray(content);

//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                System.out.println(jsonObject.get("title"));
//            }

            String title = (String) ((JSONObject) jsonArray.get(9)).get("title");
            System.out.println("title = " + title);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
