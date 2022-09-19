package com.company.service;

import com.company.entity.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        Student st = new Student("Ali", "Aliyev", 3, "PDP",
                List.of("Java", "Database", "Spring", "DSA"));
        st.setName(null);
        System.out.println(st);

        //Gson gson = new Gson();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        String json = gson.toJson(st);

        System.out.println(json);

        System.out.println("*****************************");

        List<Student> studentList =  new ArrayList<>();
        studentList.add(st);
        studentList.add(new Student("Otabek", "Eshpulatov", 2,
                "UZMU", List.of("Java", "Database", "Spring", "DSA")));

        String json1 = gson.toJson(studentList);
        System.out.println(json1);

    }
}
