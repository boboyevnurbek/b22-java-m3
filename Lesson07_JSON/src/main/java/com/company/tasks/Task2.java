package com.company.tasks;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    static final String BASE_FOLDER = "src/main/resources";

    public static void main(String[] args) {

        String fileName = BASE_FOLDER+"/users.json";

        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));

            JSONArray jsonArray = new JSONArray(content);

            JSONObject jsonObject = (JSONObject) jsonArray.get(4);
            JSONObject companyObject = (JSONObject) jsonObject.get("company");
            String companyName = (String) companyObject.get("name");
            System.out.println("companyName = " + companyName);

            JSONObject userObject = jsonArray.getJSONObject(4);
            JSONObject addressObject = userObject.getJSONObject("address");
            String city = addressObject.getString("city");
            System.out.println("city = " + city);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
