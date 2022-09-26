package com.company.service;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.SortedMap;

public class App1 {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println("response = " + response);
        System.out.println("response.body().string() = " +
                Objects.requireNonNull(response.body()).string());
    }
}
