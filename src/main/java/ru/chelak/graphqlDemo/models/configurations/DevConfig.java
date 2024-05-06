package ru.aristov.graphqlDemo.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Development configuration");
    }
}
