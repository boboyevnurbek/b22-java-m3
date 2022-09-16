package com.company;

import com.company.files.WorkWithFiles;
import com.company.service.TestService;
import com.company.util.ScannerUtil;

public class Application {
    public static TestService testService = new TestService();

    public static void main(String[] args) {

        try {
            WorkWithFiles.readQuestionsFromFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        while(true) {
            try {
                System.out.println();
                System.out.println("1. Add question");
                System.out.println("2. Take a test");
                System.out.println("3. Show question list");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                String operation = ScannerUtil.SCANNER_STR.nextLine();

                if(operation.equals("0")) break;

                switch (operation){
                    case "1" -> testService.addQuestion();
                    case "2" -> testService.takeTest();
                    case "3" -> testService.showQuestionList();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
