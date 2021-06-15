package ru.otus.springBootHomework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
    String questionNumber;
    String question;
    String correctResponse;
}
