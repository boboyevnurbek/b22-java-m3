package com.company.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class App4 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/todos").newBuilder();

        urlBuilder.addQueryParameter("userId", "8");
        urlBuilder.addQueryParameter("id", "150");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();

        System.out.println("body = " + body);
    }
}
