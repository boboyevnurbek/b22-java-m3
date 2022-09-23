package com.company.service;

import java.net.MalformedURLException;
import java.net.URL;

public class App4 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments?postId=77");

            System.out.println("url.getProtocol() = " + url.getProtocol());
            System.out.println("url.getHost() = " + url.getHost());
            System.out.println("url.getPort() = " + url.getPort());
            System.out.println("url.getDefaultPort() = " + url.getDefaultPort());
            System.out.println("url.getPath() = " + url.getPath());
            System.out.println("url.getQuery() = " + url.getQuery());

            System.out.println("url.getFile() = " + url.getFile());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
