package com.company.service;

import com.company.entity.Book;
import com.company.entity.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {
//        m1();
        m2();
    }
    private static void m2() {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls().create();

        File file = new File("src/main/resources/students.json");

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file))) {

            Student[] students = gson.fromJson(bufferedReader, Student[].class);

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void m1() {

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls().create();

        File file = new File("src/main/resources/student.json");

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file))) {

            Student student = gson.fromJson(bufferedReader, Student.class);

            System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
