package com.school.domain.service;

import com.school.domain.db.Database;
import com.school.domain.entity.Subject;
import com.school.domain.payload.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubjectService {
    public Result editSubject(int subjectId, String newName) {

        Subject subject = getSubjectById(subjectId);
        if (subject == null || newName.isBlank()) {
            return new Result("A subject with this id doesn't exist or name is empty", false);
        }

        if (subject.getName().equalsIgnoreCase(newName)) {
            subject.setName(newName);
            return new Result("A subject has been successfully edited", true);
        }

        Subject subject2 = Database.SUBJECTS.stream()
                .filter(subject1 -> subject1.getName().equalsIgnoreCase(newName))
                .findFirst().orElse(null);

        if (subject2 != null)
            return new Result("Subject with this name already exists", false);

        subject.setName(newName);
        return new Result("A subject has been successfully edited", true);
    }

    public Result addSubject(String name) {

        if (name == null || name.isBlank())
            return new Result("name is required", false);

        String str = name.trim();
        Subject subject = Database.SUBJECTS.stream()
                .filter(sbj -> sbj.getName().equalsIgnoreCase(str))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(subject))
            return new Result("Subject exist with this name", false);

        subject = new Subject(Database.SUBJECTS.size() + 1, str);
        Database.SUBJECTS.add(subject);

        return new Result("Successfully created", true);
    }

    public List<Subject> getSubjectList() {
        return Database.SUBJECTS.stream()
                .filter(subject -> !subject.isDeleted())
                .collect(Collectors.toList());
    }

    public Subject getSubjectById(Integer subjectId) {
        return Database.SUBJECTS.stream()
                .filter(subject -> subject.getId().equals(subjectId) && !subject.isDeleted())
                .findFirst().orElse(null);
    }

    public Result deleteSubject(Integer subjectId) {
        Subject subject = getSubjectById(subjectId);

        if (subject == null) {
            return new Result("Subject not found", false);
        }

        if (subject.isDeleted())
            return new Result("Subject already deleted", false);

        subject.setDeleted(true);
        return new Result("Subject has been successfully deleted", true);
    }
}
