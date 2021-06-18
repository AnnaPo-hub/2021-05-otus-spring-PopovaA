package ru.otus.spring.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionnaireResults {

    public boolean checkResults(int correctReplyQuantity) {
        final int passed = 3;
        return correctReplyQuantity >= passed;
    }

    public String showResults(String user, boolean results) {
        if (results) {
            return "Dear " + user + ", congratulations!You have passed the test!";
        } else
            return "Dear " + user + ", you have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.";
    }
}
