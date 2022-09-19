package com.company.service;

import com.company.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
//        m1();
        m2();
    }
    private static void m2() {
        String json = "[\n" +
                "  {\n" +
                "    \"title\": \"Java\",\n" +
                "    \"author\": \"Otabek\",\n" +
                "    \"price\": 100.0\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Java\",\n" +
                "    \"author\": \"Otabek\",\n" +
                "    \"price\": 100.0\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Java\",\n" +
                "    \"author\": \"Otabek\",\n" +
                "    \"price\": 100.0\n" +
                "  }\n" +
                "]";

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls().create();

        Book[] books = gson.fromJson(json, Book[].class);
        // Book list shaklida o'qish

        System.out.println(Arrays.toString(books));
    }

    private static void m1() {
        String json = "{\n" +
                "    \"title\": \"Java\",\n" +
                "    \"author\": \"Otabek\",\n" +
                "    \"price\": 100.0\n" +
                "  }";

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls().create();

        Book book = gson.fromJson(json, Book.class);

        System.out.println(book);
    }
}
