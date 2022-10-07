package com.school.core.ui;

import com.school.core.Application;
import com.school.core.util.ScannerUtil;
import com.school.domain.entity.Subject;
import com.school.domain.payload.Result;
import com.school.domain.service.SubjectService;

import java.util.List;


public class SubjectUI {

    public static void subjectCRUD() {

        while (true) {

            System.out.println();
            String choice = getSubjectMenu();

            if (choice.equals("0")) break;

            switch (choice) {
                case "1" -> createSubject();
                case "2" -> readSubjects();
                case "3" -> editSubject();
                case "4" -> deleteSubject();
            }
        }

    }

    private static void deleteSubject() {

    }

    private static void editSubject() {

    }

    private static void readSubjects() {

        List<Subject> subjectList = Application.subjectService.getSubjectList();

        if (subjectList.isEmpty()) {

            System.out.println("No subjects added yet.");

        } else {

            for (Subject subject : subjectList) {
                System.out.println("Subject name: " + subject.getName());
            }

        }
    }

    private static void createSubject() {

        System.out.print("Enter name for a subject: ");
        String name = ScannerUtil.SCANNER_STR.nextLine();


        Result result = Application.subjectService.addSubject(name);

        if (result.isSuccess()) {
            System.out.println(result.getMessage());
        } else {
            System.err.println(result.getMessage());
        }

    }


    private static String getSubjectMenu() {
        System.out.println("1. Create new subject");
        System.out.println("2. Read subject list");
        System.out.println("3. Edit subject");
        System.out.println("4. Delete subject ");
        System.out.println("0. Back");
        System.out.print("Enter operation number: ");
        return ScannerUtil.SCANNER_STR.nextLine();
    }
}
