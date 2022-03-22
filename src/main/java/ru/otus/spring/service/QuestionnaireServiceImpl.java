package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.utils.Greeting;
import ru.otus.spring.utils.QuestionShow;
import ru.otus.spring.utils.QuestionnaireResults;

import java.io.FileNotFoundException;

@Service
@PropertySource("classpath:application.properties")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;

    @Value("${pathToQuestion}")
    String pathToQuestion;


    public QuestionnaireServiceImpl(
            Greeting greeting, QuestionShow questionShow,
            QuestionnaireResults questionnaireResults,
            QuestionDao questionDao) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        String userName = greeting.askUserName();
        boolean results = questionnaireResults.checkResults(questionShow.showQuestion(questionDao.getQuestionsFromFile(pathToQuestion)));
        System.out.println(questionnaireResults.showResults(userName, results));
    }
}
