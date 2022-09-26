package com.company.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class App7 {
    static String BASE_URL = "http://10.10.2.189:8080";

    public static void main(String[] args) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/delete").newBuilder();

        urlBuilder.addQueryParameter("id", "28");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();

        String body = response.body().string();

        System.out.println("body = " + body);
    }
}
