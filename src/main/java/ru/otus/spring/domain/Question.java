package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Question {
    String questionNumber;
    String question;
    String correctResponse;
}
