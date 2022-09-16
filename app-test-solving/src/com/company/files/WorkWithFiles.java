package com.company.files;

import com.company.Application;
import com.company.entity.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {
    public static void readQuestionsFromFile() throws Exception {

        File file = new File("documents/questions.txt");
        if(!file.exists()) {
            throw new Exception("File not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String title = null;
            while ((title = reader.readLine()) != null) {

                if(title.isBlank()) continue;
                String[] variantArray = reader.readLine().split("/");
                String correctAnswer = variantArray[0];

                Question question = new Question(title, new ArrayList<>(List.of(variantArray)), correctAnswer);

                Application.testService.questionList.add(question);
            }

        }catch (Exception e){

        }
    }

    public static void addQuestionToFile(Question question) throws Exception {
        File file = new File("documents/questions.txt");
        if(!file.exists()) {
            throw new Exception("File not found");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

           writer.println(question.getTitle());

            String reduce = question.getVariants().stream()
                    .reduce("", (s, s2) -> s + "/"+s2);

            writer.println(reduce.substring(1));

        }catch (Exception e){

        }
    }
}
