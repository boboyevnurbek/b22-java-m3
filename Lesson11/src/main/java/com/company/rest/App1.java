package com.company.rest;

import okhttp3.*;

import java.io.IOException;

public class App1 {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();

        MediaType textPlainMT = MediaType.parse("text/plain; charset=utf-8");

        String helloMsg = "Hello OkHttp";

        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(RequestBody.create(textPlainMT, helloMsg))
                .build();

        Response response = client.newCall(request).execute();

        System.out.println("response.body().string() = " + response.body().string());
        response.close();
    }
}
