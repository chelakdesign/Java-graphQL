package ru.aristov.graphqlDemo.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Common configuration");
    }
}
