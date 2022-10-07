package com.school.core;


import com.school.core.ui.*;
import com.school.core.util.ScannerUtil;
import com.school.domain.service.*;

public class Application {

    public static final SubjectService subjectService = new SubjectService();
    public static final TeacherService teacherService = new TeacherService();
    public static final StudentService studentService = new StudentService();
    public static final ClassService classService = new ClassService();
    public static final MarkService markService = new MarkService();

    public static void main(String[] args) {

        while (true){
            System.out.println();
            String choose = getBaseMenu();

            if(choose.equals("0")) break;

            switch (choose){
                case "1" -> SubjectUI.subjectCRUD();
                case "2" -> TeacherUI.teacherCRUD() ;
                case "3" -> ClassUI.classCRUD();
                case "4" -> StudentUI.studentCRUD();
                case "5" -> MarkUI.markCRUD();
            }
        }
    }

    private static String getBaseMenu() {
        System.out.println("1. Subject CRUD");
        System.out.println("2. Teacher CRUD");
        System.out.println("3. Class CRUD");
        System.out.println("4. Student CRUD");
        System.out.println("5. Mark CRUD");
        System.out.println("0. Exit");
        System.out.print("Enter operation number: ");
        return ScannerUtil.SCANNER_STR.nextLine();
    }
}
