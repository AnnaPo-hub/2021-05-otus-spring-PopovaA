package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;

import java.io.FileNotFoundException;

public class QuestionnaireService {

     private final QuestionDao dao;

    //IoC
    public QuestionnaireService(QuestionDao dao) {
        this.dao = dao;
    }

    public void playQuestions() throws FileNotFoundException {
        dao.showQuestion();
    }
}
