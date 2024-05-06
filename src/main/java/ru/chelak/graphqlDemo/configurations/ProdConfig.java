package ru.chelak.graphqlDemo.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProdConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Production configuration");
    }
}
