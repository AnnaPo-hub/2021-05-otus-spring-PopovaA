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
        Assertions.assertFalse(questionnaireResults.showResults("Ivan Ivanov", 1));
    }

    @Test
    void shouldShowPositiveResult() throws FileNotFoundException {
        Assertions.assertTrue(questionnaireResults.showResults("Ivan Ivanov", 5));
    }

    @Test
    void shouldGetQuestionsFromFile() throws FileNotFoundException {
        final List<Question> questionsFromFile = dao.getQuestionsFromFile("target/classes/questionnaire.csv");
        Assertions.assertEquals(5, questionsFromFile.size());
    }
}
