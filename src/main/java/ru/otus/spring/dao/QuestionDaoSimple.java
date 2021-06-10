package ru.otus.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository("questionDao")
@PropertySource("classpath:score.properties")
public class QuestionDaoSimple implements QuestionDao {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private static int correctReplyQuantity;

    private String user;

    //@Value("${path}")// TO DO доработать путь из проперти
    private String path = "target/classes/questionnaire.csv";


    @Override
    public void askUserName() {
        System.out.println("Pls enter your name and surname");
        Scanner scan = new Scanner(System.in);
        user = scan.nextLine();
    }

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

    @Override
    public int showQuestion() throws FileNotFoundException {
        List<Question> questions = getQuestionsFromFile(path);
        for (Question question : questions) {
            System.out.println(question.getQuestionNumber() + " " + question.getQuestion());
            Scanner scan = new Scanner(System.in);
            String reply = scan.nextLine();
            if (reply.equals(question.getCorrectResponse())) {
                correctReplyQuantity++;
            }
        }
        return correctReplyQuantity;
    }

    @Override
    public boolean showResults(int correctReplyQuantity) {
        final int passed = 3;
        if (correctReplyQuantity >= passed) {
            System.out.println("Dear " + user + " Congratulations!You have passed the test!");
            return true;
        } else {
            System.out.println("Dear " + user + " You have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.");
            return false;
        }
    }
}
