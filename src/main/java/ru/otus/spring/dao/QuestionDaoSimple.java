package ru.otus.spring.dao;

import ru.otus.spring.dao.QuestionDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionDaoSimple implements QuestionDao {

    String path;

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void showQuestion() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine().replaceAll(",", " "));
        }
    }
}
