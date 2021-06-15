package ru.otus.springBootHomework.utils;

import org.springframework.context.annotation.Configuration;

@Configuration("results")
public class QuestionnaireResults {

    public boolean showResults(String user, int correctReplyQuantity) {
        final int passed = 3;
        if (correctReplyQuantity >= passed) {
            System.out.println("Dear " + user + " Congratulations!You have passed the test!");
            return true;
        } else {
            System.out.println("Dear " + user + ", " + " You have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.");
            return false;
        }
    }
}
