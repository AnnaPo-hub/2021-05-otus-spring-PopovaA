package ru.otus.spring.dao;

import java.io.FileNotFoundException;

public interface QuestionDao {
    void askUserName();

    int showQuestion() throws FileNotFoundException;

    boolean showResults(int correctReplyQuantity);
}
