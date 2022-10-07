package com.school.domain.service;

import com.school.domain.db.Database;
import com.school.domain.entity.Subject;

import java.util.List;
import java.util.Objects;

public class SubjectService {
    public Subject addSubject(String name){
        Subject subject = Database.SUBJECTS.stream()
                .filter(sbj -> sbj.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if(Objects.nonNull(subject)) return null;

        subject = new Subject(Database.SUBJECTS.size() + 1, name);
        Database.SUBJECTS.add(subject);

        return subject;
    }

    public List<Subject> getSubjectList(){
        return Database.SUBJECTS;
    }
}
