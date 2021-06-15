package ru.otus.springBootHomework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "application")
public class AppConfig {

    String pathToQuestion;


//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
//        PropertySourcesPlaceholderConfigurer properties =
//                new PropertySourcesPlaceholderConfigurer();
//        properties.setLocation(new FileSystemResource("target/classes/application.properties"));
//        properties.setIgnoreResourceNotFound(false);
//        return properties;
//    }
}


