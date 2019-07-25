package com.obss.movietracker.movietracker.springwebservice.Controller;

import com.obss.movietracker.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.movietracker.springwebservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getMovies() {
        List<MovieEntity> movies = movieService.getMovies();

        if (movies == null) {
            return new ResponseEntity<>(new InfoMessage("Movies not found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
