package ru.otus.springBootHomework.dao;

import ru.otus.springBootHomework.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionDao {

    List<Question> getQuestionsFromFile(String path) throws FileNotFoundException;
}
