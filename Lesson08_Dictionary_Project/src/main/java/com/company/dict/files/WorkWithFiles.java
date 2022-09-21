package com.company.dict.files;

import com.company.dict.entity.Result;
import com.company.dict.entity.Word;
import com.company.dict.service.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class WorkWithFiles {
    static File file = new File("src/main/resources/dictionary.json");
    static File resultFile = new File("src/main/resources/result.json");
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static public void write(){

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(gson.toJson(Main.wordList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        if(!file.exists()) return;

        try (FileReader reader = new FileReader(file)) {

            Type type = new TypeToken<List<Word>>() {}.getType();

            List<Word> words = gson.fromJson(reader, type);
            Main.wordList.clear();
            Main.wordList.addAll(words);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///////////////

    static public void writeResult(){

        try (PrintWriter writer = new PrintWriter(resultFile)) {
            writer.write(gson.toJson(Main.resultList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readResult() {
        if(!resultFile.exists()) return;

        try (FileReader reader = new FileReader(resultFile)) {

            Type type = new TypeToken<List<Result>>() {}.getType();

            List<Result> results = gson.fromJson(reader, type);
            Main.resultList.clear();
            Main.resultList.addAll(results);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
