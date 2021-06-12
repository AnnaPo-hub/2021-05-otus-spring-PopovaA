package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.Greeting;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dao.QuestionShow;
import ru.otus.spring.dao.Results;

import java.io.FileNotFoundException;

@Service
@PropertySource("classpath:application.properties")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final Results results;
    private final QuestionDao questionDao;

    @Value("${path}")// TO DO доработать путь из проперти
    String path; //= "target/classes/questionnaire.csv";

    //    public QuestionnaireServiceImpl(@Qualifier("questionDao") QuestionDao dao) {
//        this.dao = dao;
//    }
    public QuestionnaireServiceImpl(@Qualifier("askUserName") Greeting greeting,
                                    @Qualifier("questionShow") QuestionShow questionShow,
                                    @Qualifier("results") Results results,
                                    @Qualifier("questionDao") QuestionDao questionDao) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.results = results;
        this.questionDao = questionDao;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        results.showResults(greeting.askUserName(),
                questionShow.showQuestion(questionDao.getQuestionsFromFile(path)));
    }
}
