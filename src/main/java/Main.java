import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionnaireService;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionnaireService service = context.getBean(QuestionnaireService.class);
        service.playQuestions();
    }
}
