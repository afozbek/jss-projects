package com.obss.movietracker;

import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Util.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MovietrackerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public static void main(String[] args) {

        SpringApplication.run(MovietrackerApplication.class, args);


        System.out.println("Application is running correctly 😊");
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserEntity(
                "afozbek",
                passwordService.hashPassword("test"), new ArrayList<>()));
    }

}
