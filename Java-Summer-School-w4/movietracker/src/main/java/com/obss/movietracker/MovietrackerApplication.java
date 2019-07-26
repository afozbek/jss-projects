package com.obss.movietracker;

import com.google.common.hash.Hashing;
import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class MovietrackerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(MovietrackerApplication.class, args);


        System.out.println("Application is running correctly 😊");
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserEntity(
                "test@test.com",
                Hashing.sha256()
                        .hashString("test", StandardCharsets.UTF_8)
                        .toString(), true));
    }

}
