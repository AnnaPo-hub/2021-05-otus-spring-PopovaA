package ru.otus.springBootHomework.dao;

import org.springframework.stereotype.Component;
import ru.otus.springBootHomework.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("questionDao")
public class QuestionDaoSimple implements QuestionDao {

    public List<Question> getQuestionsFromFile(String path) throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String nextQuestion = scanner.nextLine();
            String[] parts = nextQuestion.split(", ");
            Question question = new Question(parts[0], parts[1], parts[2]);
            questions.add(question);
        }
        return questions;
    }
}
