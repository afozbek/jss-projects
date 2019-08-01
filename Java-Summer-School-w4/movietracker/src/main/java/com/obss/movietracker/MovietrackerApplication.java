package com.obss.movietracker;

import com.obss.movietracker.springwebservice.DAO.DirectorRepository;
import com.obss.movietracker.springwebservice.DAO.MovieRepository;
import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Impl.Util.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class MovietrackerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PasswordServiceImpl passwordService;

    public static void main(String[] args) {

        SpringApplication.run(MovietrackerApplication.class, args);


        System.out.println("Application is running correctly 😊");
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new UserEntity(
                "afozbek",
                "Furkan",
                "Ozbek",
                passwordService.hashPassword("test"),
                new ArrayList<>(
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"),
                                new SimpleGrantedAuthority("ROLE_USER"))
                )));
        DirectorEntity director = new DirectorEntity("Furkan", "ozbek", new Date(), "Usküdar");
        DirectorEntity director1 = new DirectorEntity("Sena", "Modanlıoglu", new Date(), "Gaziosmanpaşa");
        directorRepository.save(director);
        directorRepository.save(director1);
        movieRepository.save(new MovieEntity("Interstellar", new Date(), 3.5, Genre.ACTION, director));
        movieRepository.save(new MovieEntity("Lord Of The Rings", new Date(), 3.5, Genre.DRAMA, director1));
    }

}
