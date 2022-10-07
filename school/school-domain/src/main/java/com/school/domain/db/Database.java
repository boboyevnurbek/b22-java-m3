package com.school.domain.db;

import com.school.domain.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    List<Subject> SUBJECTS = new ArrayList<>();
    List<Teacher> TEACHERS = new ArrayList<>();
    List<Student> STUDENTS = new ArrayList<>();
    List<Clazz> CLASSES = new ArrayList<>();
    List<Mark> MARKS = new ArrayList<>();
}
