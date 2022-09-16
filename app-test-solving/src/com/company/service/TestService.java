package com.company.service;

import com.company.entity.Question;
import com.company.files.WorkWithFiles;
import com.company.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestService {
    public List<Question> questionList = new ArrayList<>();

    public void addQuestion() throws Exception {
        System.out.println("Enter title: ");
        String title = ScannerUtil.SCANNER_STR.nextLine();

        if(title.isBlank()) throw new Exception("Title cannot be empty");

        System.out.println("Enter 3 wrong variants (example: 10/15/12) : ");
        String line = ScannerUtil.SCANNER_STR.nextLine();

        String[] varArray = line.split("/");
        if(varArray.length != 3) throw new Exception("Incorrect variants");

        for (String v : varArray) {
            if(v.isBlank()) throw new Exception("Incorrect variants");
        }

        System.out.println("Enter correct answer: ");
        String correctAnswer = ScannerUtil.SCANNER_STR.nextLine();

        if(correctAnswer.isBlank()) throw new Exception("Correct answer cannot be empty");

        if(List.of(varArray).contains(correctAnswer))
            throw new Exception("Incorrect correct answer");

        Question question = new Question(
                title, new ArrayList<>(List.of(correctAnswer, varArray[0], varArray[1], varArray[2])),
                correctAnswer
        );


        WorkWithFiles.addQuestionToFile(question);

        questionList.add(question);

        System.out.println("ok");
    }

    public void takeTest() {
        int numbers = 0;
        
        Collections.shuffle(questionList);
        
        for (int i = 0; i < 3; i++) {
            Question question = questionList.get(i);
            System.out.printf("\n%d. %s \n", i+1, question.getTitle());
            
            Collections.shuffle(question.getVariants());

            for (int j = 0; j < 4; j++) {
                System.out.printf("%c) %s \n", (char)(j+65), question.getVariants().get(j));
            }

            System.out.print("Enter answer (not A B C D): ");
            String guess = ScannerUtil.SCANNER_STR.nextLine();

            if(question.getCorrectAnswer().equals(guess)){
                numbers++;
            }
        }

        System.out.printf("Your result : %d/%d", numbers, 3);
    }

    public void showQuestionList() {
        questionList.forEach(System.out::println);
    }
}
