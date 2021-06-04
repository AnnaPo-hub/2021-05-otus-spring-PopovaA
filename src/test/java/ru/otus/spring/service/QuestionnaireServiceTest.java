package ru.otus.spring.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.QuestionDaoSimple;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.*;

class QuestionnaireServiceTest {

    private QuestionnaireService service;
    private QuestionDaoSimple dao;

    @Before
    public void setUp(){
        dao = mock(QuestionDaoSimple.class);
        service = new QuestionnaireService(dao);
    }

    @Test
    public void shouldTestShowQuestionWasCalled () throws FileNotFoundException {
       service.playQuestions();
       verify(dao,times(1)).showQuestion();
    }
}
