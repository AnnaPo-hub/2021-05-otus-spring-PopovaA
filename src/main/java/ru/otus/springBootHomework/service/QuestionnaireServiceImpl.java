package ru.otus.springBootHomework.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.springBootHomework.dao.QuestionDao;
import ru.otus.springBootHomework.utils.Greeting;
import ru.otus.springBootHomework.utils.QuestionShow;
import ru.otus.springBootHomework.utils.QuestionnaireResults;

import java.io.FileNotFoundException;

@Service
//@PropertySource("classpath:application.properties")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;

    //@Value("${pathToQuestion}")
    String pathToQuestion = "target/classes/questionnaire.csv";


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
