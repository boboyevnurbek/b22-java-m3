package com.company.service;

import org.json.JSONArray;
import org.json.JSONObject;

public class App3 {
    public static void main(String[] args) {
//        JSONObject => JSONArray, JSONObject, boolean, string, number, null

        JSONObject todoJson = new JSONObject();
        todoJson.put("id", 1000);
        todoJson.put("userId", 50);
        todoJson.put("title", "finish lesson 7");
        todoJson.put("completed", false);

        System.out.println("todoJson = " + todoJson);

        JSONArray todoArray = new JSONArray();
        todoArray.put(todoJson);
        todoArray.put(todoJson);

        System.out.println("todoArray = " + todoArray);

        System.out.println("todoArray.length() = " + todoArray.length());

    }
}
