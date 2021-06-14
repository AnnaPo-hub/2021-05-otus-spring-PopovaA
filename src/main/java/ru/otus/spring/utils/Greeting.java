package ru.otus.spring.utils;

import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration("askUserName")
public class Greeting {
    public String askUserName() {
        System.out.println("Hello! Please enter your name and surname");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
