package com.company.service;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class App2 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(BASE_URL + "/todos").newBuilder();
        urlBuilder.addQueryParameter("userId", "5");
        urlBuilder.addQueryParameter("id", "100");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println("response = " + response);
        System.out.println("response.body().string() = " +
                Objects.requireNonNull(response.body()).string());
    }
}
