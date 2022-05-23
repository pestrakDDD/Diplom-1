package ru.churikov.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class Main {
    private static Initializer initializer;

    @Autowired
    public void setInitialLoader(Initializer initializer) {
        Main.initializer = initializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        initializer.initial();
    }
}
