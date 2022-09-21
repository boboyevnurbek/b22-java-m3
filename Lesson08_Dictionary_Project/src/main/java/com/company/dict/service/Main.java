package com.company.dict.service;

import com.company.dict.entity.Result;
import com.company.dict.entity.Word;
import com.company.dict.files.WorkWithFiles;
import com.company.dict.util.ScannerUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final List<Word> wordList = new ArrayList<>();
    public static final List<Result> resultList = new ArrayList<com.company.dict.entity.Result>();

    public static void main(String[] args) {

        WorkWithFiles.read();
        WorkWithFiles.readResult();

        while (true) {
            String choose = menu();
            if (choose.equals("0")) break;

            switch (choose) {
                case "1" -> addNewWord();
                case "2" -> translateWords();
                case "3" -> showWords();
                case "4" -> showResults();
            }
        }

    }

    private static void showResults() {
        if (resultList.isEmpty()) {
            System.out.println("No results");
        } else {
            resultList.forEach(System.out::println);
        }
    }

    private static void showWords() {
        if (wordList.isEmpty()) {
            System.out.println("No words");
        } else {
            wordList.forEach(System.out::println);
        }
    }

    private static void translateWords() {
        List<Word> words = new ArrayList<>(wordList);
        Collections.shuffle(words);

        int score = 0;
        int countQuestion = 0;
        int i = 3;

        for (Word word : words) {
            if (i == 0) break;

            LocalDateTime stopTime = LocalDateTime.now().plusSeconds(11);
            System.out.print(word.getEng() + "(time: 10 second, quit = stop quiz) = ");
            String answer = ScannerUtil.SCANNER_STR.nextLine();

            if (answer.equalsIgnoreCase("quit")) break;

            countQuestion++;

            if (LocalDateTime.now().isBefore(stopTime) && word.getUzb().contains(answer)) {
                score++;
                System.out.println("😎");
            } else {
                i--;
                System.out.print("😥");
                System.out.println(word.getUzb());
            }
        }

        System.out.println("You get " + score + "/" + countQuestion);

        Result result = new Result(score, countQuestion,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        resultList.add(result);

        WorkWithFiles.writeResult();

    }

    private static void addNewWord() {
        System.out.print("Enter english word: ");
        String eng = ScannerUtil.SCANNER_STR.nextLine().trim().toLowerCase();

        if (eng.isBlank()) return;

        System.out.printf("Enter translate of \"%s\" : ", eng);
        String uzb = ScannerUtil.SCANNER_STR.nextLine().trim().toLowerCase();

        if (uzb.isBlank()) return;

        Word word = null;

        for (Word w : wordList) {
            if (w.getEng().equalsIgnoreCase(eng)) {
                word = w;
                break;
            }
        }

        if (word == null) {
            word = new Word(eng, new ArrayList<>(List.of(uzb)));
            wordList.add(word);
        } else {
            if (!word.getUzb().contains(uzb)) {
                word.getUzb().add(uzb);
            }
        }
        wordList.sort(Comparator.comparing(Word::getEng));

        WorkWithFiles.write();
        System.out.println("success");
    }

    private static String menu() {
        System.out.println();
        System.out.println("1. Add new word");
        System.out.println("2. Translate words");
        System.out.println("3. Show words");
        System.out.println("4. Show results");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
        return ScannerUtil.SCANNER_STR.nextLine();
    }
}
