package com.company.tasks;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {
    static final String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {

        String fileName = BASE_FOLDER+"/users.json";

        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userObject = jsonArray.getJSONObject(i);
                String name = userObject.getString("name");
                String company = userObject.getJSONObject("company").getString("name");
                String city = userObject.getJSONObject("address").getString("city");

                System.out.printf("%d. %s  %s  %s \n", i+1, name, company, city);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
