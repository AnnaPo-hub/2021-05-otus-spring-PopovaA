package ru.otus.spring.utils;

import org.springframework.context.annotation.Configuration;
import ru.otus.spring.domain.Question;

import java.util.List;
import java.util.Scanner;

@Configuration
public class QuestionShow {

    public int showQuestion(List<Question> questions) {
        int correctReplyQuantity = 0;
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
}
