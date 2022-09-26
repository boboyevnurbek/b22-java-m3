package com.company.service;

import okhttp3.*;

import java.io.IOException;

public class App5 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("userId", "8")
                .add("title", "test uchun")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/todos")
//                .method("POST", requestBody)
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();

        System.out.println("body = " + body);
    }
}
