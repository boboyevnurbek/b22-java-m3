package uz.b22.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private String surname;
    private int course;
    private String university;


//    public Student() {
//    }

//    public Student(String name, String surname, int course) {
//        this.name = name;
//        this.surname = surname;
//        this.course = course;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getCourse() {
//        return course;
//    }
//
//    public void setCourse(int course) {
//        this.course = course;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", course=" + course +
//                '}';
//    }
}
