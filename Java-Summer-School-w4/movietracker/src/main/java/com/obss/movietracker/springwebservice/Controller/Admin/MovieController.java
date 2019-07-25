package com.obss.movietracker.springwebservice.Controller.Admin;

import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    // GET MOVIE OR MOVIES
    @GetMapping
    public ResponseEntity<?> getMovies(@RequestParam(required = false, name = "movie") String movieName) {

        List<MovieEntity> movies = movieService.getMovieByName(movieName);

        if (movies.size() == 0) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // POST MOVIE
    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieEntity movieEntity) {
        if (movieEntity.getName() == null || movieEntity.getDirector() == null) {
            return new ResponseEntity<>(new ErrorMessage("Your movie must have a director"), HttpStatus.BAD_REQUEST);
        }

        if (!movieService.updateMovie(movieEntity)) {
            return new ResponseEntity<>(new ErrorMessage("Movie Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(movieService.getMovieByName(movieEntity.getName()), HttpStatus.CREATED);
    }

    // UPDATE MOVIE
    @PutMapping
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
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (movieService.deleteMovie(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Movie was not deleted"), HttpStatus.BAD_REQUEST);
    }
}
