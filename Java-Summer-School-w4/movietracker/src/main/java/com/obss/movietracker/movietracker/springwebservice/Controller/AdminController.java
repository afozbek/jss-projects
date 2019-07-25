package com.obss.movietracker.movietracker.springwebservice.Controller;

import com.google.common.hash.Hashing;
import com.obss.movietracker.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.movietracker.springwebservice.Service.DirectorService;
import com.obss.movietracker.movietracker.springwebservice.Service.MovieService;
import com.obss.movietracker.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private DirectorService directorService;

    ////// USER MANAGEMENT \\\\\\
    // GETTING USER OR USERS ✔
    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@RequestParam(required = false, name = "email") String email) {

        UserEntity userEntity = userService.findUserByEmail(email);

        if (userEntity == null) {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    // CREATING USER ✔
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        if (userEntity.getEmail() == null || userEntity.getPassword() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your email and password"), HttpStatus.BAD_REQUEST);
        }

        if (!userService.registerUser(userEntity)) {
            return new ResponseEntity<>(new ErrorMessage("UserEntity Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    // UPDATING USER
    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity) {
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        String firstName = userEntity.getFirstName();
        String lastName = userEntity.getLastName();

        if (email == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = userService.findUserByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(new InfoMessage("User not found"), HttpStatus.NOT_FOUND);
        }

        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        user.setEmail(email);
        user.setPassword(hashedPassword);

        if (firstName != null || lastName != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
        }

        userService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Update successfull 😊"), HttpStatus.OK);
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("User was not deleted"), HttpStatus.BAD_REQUEST);
    }

    ////// MOVIE MANAGEMENT \\\\\\
    // GETTING MOVIE OR MOVIES
    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(required = false, name = "movie") String movieName) {

        List<MovieEntity> movies = movieService.getMovieByName(movieName);

        if (movies.size() == 0) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // POSTING MOVIE
    @PostMapping("/movies")
    public ResponseEntity<?> createMovie(@RequestBody MovieEntity movieEntity) {
        if (movieEntity.getName() == null || movieEntity.getDirector() == null) {
            return new ResponseEntity<>(new ErrorMessage("Your movie must have a director"), HttpStatus.BAD_REQUEST);
        }

        if (!movieService.updateMovie(movieEntity)) {
            return new ResponseEntity<>(new ErrorMessage("Movie Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(movieService.getMovieByName(movieEntity.getName()), HttpStatus.CREATED);
    }

    // UPDATING MOVIE
    @PutMapping("/movies")
    public ResponseEntity<?> updateMovie(@RequestBody MovieEntity movie) {
        String movieName = movie.getName();
        String genre = movie.getGenre();
        DirectorEntity director = movie.getDirector();

        if (movieName == null || genre == null || director == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        List<MovieEntity> movies = movieService.getMovieByName(movieName);

        if (movies == null) {
            return new ResponseEntity<>(new InfoMessage("Movies not found"), HttpStatus.NOT_FOUND);
        }

        movie.setName(movieName);
        movie.setGenre(genre);
        movie.setDirector(director);

        if (!movieService.updateMovie(movie)) {
            return new ResponseEntity<>(new ErrorMessage("Update failed!"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(new InfoMessage("Update successfull 😊"), HttpStatus.OK);
    }

    // DELETE MOVIE
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (movieService.deleteMovie(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Movie was not deleted"), HttpStatus.BAD_REQUEST);
    }

    ////// DIRECTOR MANAGEMENT \\\\\\
    // GETTING DIRECTOR OR DIRECTORS
    @GetMapping("/directors")
    public ResponseEntity<?> getDirectors(@RequestParam(required = false, name = "director") String directorName) {

        List<DirectorEntity> movies = directorService.getDirectorByName(directorName);

        if (movies.size() > 0) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // POSTING DIRECTOR
    @PostMapping("/directors")
    public ResponseEntity<?> createDirector(@RequestBody DirectorEntity director) {
        if (director.getName() == null || director.getSurname() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill fields"), HttpStatus.BAD_REQUEST);
        }

        if (!directorService.updateDirector(director)) {
            return new ResponseEntity<>(new ErrorMessage("Director Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(new InfoMessage("Director creation success 😊"), HttpStatus.CREATED);
    }

    // UPDATING DIRECTOR
    @PutMapping("/directors")
    public ResponseEntity<?> updateDirector(@RequestBody DirectorEntity director) {
        String directorName = director.getName();
        String surname = director.getSurname();
        Date birthDate = director.getBirthDate();

        if (directorName == null || surname == null || birthDate == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        List<DirectorEntity> directors = directorService.getDirectorByName(directorName);

        if (directors == null) {
            return new ResponseEntity<>(new InfoMessage("Movies not found"), HttpStatus.NOT_FOUND);
        }

        director.setName(directorName);
        director.setSurname(surname);
        director.setBirthDate(birthDate);

        if (!directorService.updateDirector(director)) {
            return new ResponseEntity<>(new ErrorMessage("Update failed!"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(new InfoMessage("Update successfull 😊"), HttpStatus.OK);
    }

    // DELETE DIRECTOR
    @DeleteMapping("/directors/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable Long id) {
        if (directorService.deleteDirector(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Director was not deleted"), HttpStatus.BAD_REQUEST);
    }

}
