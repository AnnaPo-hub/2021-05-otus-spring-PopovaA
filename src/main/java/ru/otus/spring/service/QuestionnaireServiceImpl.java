package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;

import java.io.FileNotFoundException;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionDao dao;

    public QuestionnaireServiceImpl(@Qualifier("questionDao") QuestionDao dao) {
        this.dao = dao;
    }

    public void playQuestions() throws FileNotFoundException {
        dao.askUserName();
        dao.showResults(dao.showQuestion());
    }
}
