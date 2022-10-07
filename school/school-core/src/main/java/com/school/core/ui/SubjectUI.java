package com.school.core.ui;

import com.school.core.Application;
import com.school.core.io.InOut;
import com.school.core.util.ScannerUtil;
import com.school.domain.db.Database;
import com.school.domain.entity.Subject;
import com.school.domain.payload.Result;
import com.school.domain.service.SubjectService;

import java.util.InputMismatchException;
import java.util.List;


public class SubjectUI {

    public static void subjectCRUD() {

        while (true) {

            InOut.printText("", InOut.ANSI_RESET);
            try {
                String choice = getSubjectMenu();

                if (choice.equals("0")) break;

                switch (choice) {
                    case "1" -> createSubject();
                    case "2" -> readSubjects();
                    case "3" -> editSubject();
                    case "4" -> deleteSubject();
                }
            }catch (InputMismatchException e){
                ScannerUtil.SCANNER_NUM.nextLine();
            }
        }

    }

    private static void deleteSubject() {
        boolean exist = readSubjects();
        if(!exist) return;

        InOut.printText("Enter subject id: ", InOut.ANSI_BLUE);
        Integer subjectId = ScannerUtil.SCANNER_NUM.nextInt();

        Result result = Application.subjectService.deleteSubject(subjectId);

        InOut.printText(result.getMessage(), result.isSuccess() ? InOut.ANSI_GREEN : InOut.ANSI_RED);
    }

    private static void editSubject() {

        boolean exist = readSubjects();
        if(!exist) return;

        InOut.printText("Enter subject id: ", InOut.ANSI_BLUE);
        Integer subjectId = ScannerUtil.SCANNER_NUM.nextInt();
        InOut.printText("New name: ", InOut.ANSI_BLUE);
        String newName = ScannerUtil.SCANNER_STR.nextLine();
        Result result = Application.subjectService.editSubject(subjectId, newName);

        InOut.printText(result.getMessage(), result.isSuccess() ? InOut.ANSI_GREEN : InOut.ANSI_RED);
    }

    private static boolean readSubjects() {

        List<Subject> subjectList = Application.subjectService.getSubjectList();

        if (subjectList.isEmpty()) {

            InOut.printText("No subjects added yet.", InOut.ANSI_RED);
            return false;
        } else {

            for (Subject subject : subjectList) {
                InOut.printText("Id: " + subject.getId() + ", Subject name: " + subject.getName(), InOut.ANSI_YELLOW);
            }

        }
        return true;
    }

    private static void createSubject() {

        InOut.printText("Enter name for a subject: ", InOut.ANSI_BLUE);
        String name = ScannerUtil.SCANNER_STR.nextLine();


        Result result = Application.subjectService.addSubject(name);

        InOut.printText(result.getMessage(), result.isSuccess() ? InOut.ANSI_GREEN : InOut.ANSI_RED);

    }

    private static String getSubjectMenu() {
        InOut.printText("1. Create new subject", InOut.ANSI_BLUE);
        InOut.printText("2. Read subject list", InOut.ANSI_BLUE);
        InOut.printText("3. Edit subject", InOut.ANSI_BLUE);
        InOut.printText("4. Delete subject ", InOut.ANSI_BLUE);
        InOut.printText("0. Back", InOut.ANSI_BLUE);
        InOut.printText("Enter operation number: ", InOut.ANSI_BLUE);
        return ScannerUtil.SCANNER_STR.nextLine();
    }
}
