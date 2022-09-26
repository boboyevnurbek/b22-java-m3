package com.company.rest;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class App2 {

    private static final MediaType MEDIA_TYPE_PLAINTEXT = MediaType
            .parse("text/plain; charset=utf-8");

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

//        RequestBody formBody = new FormBody.Builder()
//                .add("email", "otash@gmail.com")
//                .add("firstname", "Otabek")
//                .add("lastname", "Eshpolatov")
//                .build();
//
//        Request request = new Request.Builder().url("http://httpbin.org/post")
//                .post(formBody)


        File file = new File("./b22.txt");

        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(RequestBody.create(MEDIA_TYPE_PLAINTEXT, file))
                .build();

        Response response = client.newCall(request).execute();

        System.out.println("response.body().string() = " + response.body().string());

        response.close();
    }
}
