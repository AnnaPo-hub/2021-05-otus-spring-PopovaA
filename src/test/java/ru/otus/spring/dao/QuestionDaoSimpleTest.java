package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDaoSimpleTest {
    QuestionDaoSimple dao = new QuestionDaoSimple();


    @Test
    void shouldShowNegativeResult() throws FileNotFoundException {
        assertFalse(dao.showResults(1));
    }

    @Test
    void shouldShowPositiveResult() throws FileNotFoundException {
        assertTrue(dao.showResults(5));
    }

    @Test
    void shouldGetQuestionsFromFile() throws FileNotFoundException {
        final List<Question> questionsFromFile = dao.getQuestionsFromFile("target/classes/questionnaire.csv");
        assertEquals(5, questionsFromFile.size());
    }
}
