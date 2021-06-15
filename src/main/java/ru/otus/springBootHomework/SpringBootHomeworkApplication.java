package ru.otus.springBootHomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.springBootHomework.service.QuestionnaireService;

import java.io.FileNotFoundException;

@SpringBootApplication
public class SpringBootHomeworkApplication {

	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext ctx = SpringApplication.run(SpringBootHomeworkApplication.class, args);
		QuestionnaireService service = ctx.getBean(QuestionnaireService.class);
		service.startQuestionnaire();
	}
}
