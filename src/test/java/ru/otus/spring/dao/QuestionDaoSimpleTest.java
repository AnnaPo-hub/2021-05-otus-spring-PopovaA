package ru.otus.spring.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;
import ru.otus.spring.utils.QuestionnaireResults;

import java.io.FileNotFoundException;
import java.util.List;

class QuestionDaoSimpleTest {
    QuestionDaoSimple dao = new QuestionDaoSimple();
    QuestionnaireResults questionnaireResults = new QuestionnaireResults();


    @Test
    void shouldShowNegativeResult() throws FileNotFoundException {
        Assertions.assertFalse(questionnaireResults.checkResults(1));
    }

    @Test
    void shouldShowPositiveResult() throws FileNotFoundException {
        Assertions.assertTrue(questionnaireResults.checkResults( 5));
    }

    @Test
    void shouldPrintNegativeResult(){
        Assertions.assertEquals("Dear Ivan Ivanov, you have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.",
                questionnaireResults.showResults("Ivan Ivanov", false));
    }

    @Test
    void shouldPrintPositiveResult(){
       Assertions.assertEquals("Dear Ivan Ivanov, congratulations!You have passed the test!",
               questionnaireResults.showResults("Ivan Ivanov", true));
    }

    @Test
    void shouldGetQuestionsFromFile() throws FileNotFoundException {
        final List<Question> questionsFromFile = dao.getQuestionsFromFile("target/classes/questionnaire.csv");
        Assertions.assertEquals(5, questionsFromFile.size());
    }
}
