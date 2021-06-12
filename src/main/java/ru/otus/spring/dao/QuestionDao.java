package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionDao {

    List<Question> getQuestionsFromFile(String path) throws FileNotFoundException;

//    String askUserName();
//
//    int showQuestion() throws FileNotFoundException;
//
//    boolean showResults(int correctReplyQuantity);
}
