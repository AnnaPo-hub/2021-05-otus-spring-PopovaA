package ru.otus.spring.utils;

import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class Greeting {
    public String askUserName() {
        System.out.println("Hello! Please enter your name and surname");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
