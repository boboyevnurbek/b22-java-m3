package com.company.entity;

import java.util.List;

public class Question {
    private String title;
    private List<String> variants;
    private String correctAnswer;

    public Question(String title, List<String> variants, String correctAnswer) {
        this.title = title;
        this.variants = variants;
        this.correctAnswer = correctAnswer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", variants=" + variants +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
