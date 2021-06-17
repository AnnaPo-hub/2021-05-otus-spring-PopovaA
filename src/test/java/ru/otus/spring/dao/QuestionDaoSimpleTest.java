package ru.otus.spring.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;
import ru.otus.spring.utils.QuestionnaireResults;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionDaoSimpleTest {
    QuestionDaoSimple dao = new QuestionDaoSimple();
    QuestionnaireResults questionnaireResults = new QuestionnaireResults();


    @Test
    void shouldShowNegativeResult() {
        Assertions.assertFalse(questionnaireResults.checkResults(1));
    }

    @Test
    void shouldShowPositiveResult() {
        assertTrue(questionnaireResults.checkResults(3));
    }

    @Test
    void shouldPrintNegativeResult() {
        Assertions.assertEquals("Dear Ivan Ivanov, you have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.",
                questionnaireResults.showResults("Ivan Ivanov", false));
    }

    @Test
    void shouldPrintPositiveResult() {
        Assertions.assertEquals("Dear Ivan Ivanov, congratulations!You have passed the test!",
                questionnaireResults.showResults("Ivan Ivanov", true));
    }

    @Test
    void shouldGetQuestionsFromFile() throws FileNotFoundException {
        final List<Question> questionsFromFile = dao.getQuestionsFromFile("target/classes/questionnaire.csv");
        for (Question question : questionsFromFile) {
            System.out.println(question);
        }
        Assertions.assertEquals(5, questionsFromFile.size());
    }

    @Test
    void shouldCheckQuestionsListContentFromFile() throws FileNotFoundException {
        final List<Question> questionsFromFile = dao.getQuestionsFromFile("target/classes/questionnaire.csv");
        Question question1 = new Question("1", "Who was the heir to the throne in Minas Tirith?", "Aragorn");
        Question question2 = new Question("2", "How many gnomes went with the hobbit Bilbo for the treasure?", "13");
        Question question4 = new Question("4", "Who forged the ring of omnipotence?", "Sauron");
        assertTrue(questionsFromFile.contains(question1));
        assertTrue(questionsFromFile.contains(question2));
        assertTrue(questionsFromFile.contains(question4));
    }
}
