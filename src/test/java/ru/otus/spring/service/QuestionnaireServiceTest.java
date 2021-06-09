package ru.otus.spring.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.dao.QuestionDaoSimple;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class QuestionnaireServiceTest {

    private QuestionnaireServiceImpl service;
    private QuestionDaoSimple dao;

    @Before
    public void setUp(){
        dao = new QuestionDaoSimple();
        service = new QuestionnaireServiceImpl(dao);
    }

    @Test
    public void shouldTestShowQuestionWasCalled () throws FileNotFoundException {
       service.playQuestions();
       verify(dao,times(1)).showQuestion();
    }

    @Test
    public void shouldCheck() throws FileNotFoundException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        QuestionnaireService service = context.getBean(QuestionnaireService.class);
        service.playQuestions();
        Assert.assertNotNull(context);
        Assert.assertNotNull(context.getBean("questionnaireService"));


    }
}
