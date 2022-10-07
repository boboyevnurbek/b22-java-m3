package com.school.domain.service;

import com.school.domain.db.Database;
import com.school.domain.entity.Subject;
import com.school.domain.payload.Result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubjectService {
    public Result addSubject(String name) {

        if (name == null || name.isBlank())
            return new Result("name is required", false);

        Subject subject = Database.SUBJECTS.stream()
                .filter(sbj -> sbj.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(subject))
            return new Result("Subject exist with this name", false);

        subject = new Subject(Database.SUBJECTS.size() + 1, name);
        Database.SUBJECTS.add(subject);

        return new Result("Successfully created", true);
    }

    public List<Subject> getSubjectList() {
        return Database.SUBJECTS.stream()
                .filter(subject -> !subject.isDeleted())
                .collect(Collectors.toList());
    }
}
