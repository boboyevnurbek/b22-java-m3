package uz.b22.service;

import uz.b22.entity.Student;

public class App2 {
    public static void main(String[] args) {

        Student student = new Student("Asror", "",
                3, "TATU");
        student.setSurname("Yo'ldoshev");
        System.out.println(student);
    }
}
