import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.service.QuestionnaireService;

import java.io.FileNotFoundException;
@ComponentScan(basePackages = "ru.otus.spring")
@Configuration
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        QuestionnaireService service = context.getBean(QuestionnaireService.class);
        service.playQuestions();
    }
}
