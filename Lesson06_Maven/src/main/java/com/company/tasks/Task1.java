package com.company.tasks;

import com.company.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // Book(title, author, price)
        // GSON yordamida 3 ta elementdan iborat book listni JSON listga o'tkazish
        // 10 daqiqa

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Java", "Otabek", 100d));
        bookList.add(new Book("Java", "Otabek", 100d));
        bookList.add(new Book("Java", "Otabek", 100d));

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        String json = gson.toJson(bookList);

        System.out.println(json);
    }
}
