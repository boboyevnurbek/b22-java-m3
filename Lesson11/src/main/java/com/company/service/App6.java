package com.company.service;

import okhttp3.*;

import java.io.IOException;

public class App6 {
    static String BASE_URL = "http://10.10.2.189:8080";

    public static void main(String[] args) throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("fullName", "Madina")
                .add("phoneNumber", "+998001112255")
                .add("gender", "F")
                .add("course", "2")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/add")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();

        System.out.println("body = " + body);
    }
}
