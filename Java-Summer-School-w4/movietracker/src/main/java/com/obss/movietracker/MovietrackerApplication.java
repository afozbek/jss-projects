package com.obss.movietracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovietrackerApplication {

    public static void main(String[] args) {

        SpringApplication.run(MovietrackerApplication.class, args);
        System.out.println("Application is running correctly 😊");
    }

}
