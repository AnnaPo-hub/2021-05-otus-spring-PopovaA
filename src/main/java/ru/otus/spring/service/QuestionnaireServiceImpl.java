package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
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

    @Value("${pathToQuestion}")// TO DO доработать путь из проперти
            String pathToQuestion; // = "target/classes/questionnaire.csv";


    //    public QuestionnaireServiceImpl(@Qualifier("questionDao") QuestionDao dao) {
//        this.dao = dao;
//    }
    public QuestionnaireServiceImpl(@Qualifier("askUserName") Greeting greeting,
                                    @Qualifier("questionShow") QuestionShow questionShow,
                                    @Qualifier("results") QuestionnaireResults questionnaireResults,
                                    @Qualifier("questionDao") QuestionDao questionDao) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        questionnaireResults.showResults(greeting.askUserName(),
                questionShow.showQuestion(questionDao.getQuestionsFromFile(pathToQuestion)));
    }
}
