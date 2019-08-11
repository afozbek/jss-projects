package com.obss.movietracker.springwebservice.Controller.Admin;

import com.obss.movietracker.springwebservice.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import com.obss.movietracker.springwebservice.Service.Impl.DirectorServiceImpl;
import com.obss.movietracker.springwebservice.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/admin/movie")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private DirectorServiceImpl directorService;

    // POST MOVIE
    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieEntity movie) {
        String movieName = movie.getName();
        Genre genre = movie.getGenreType();
        Date releaseDate = movie.getReleaseDate();
        DirectorEntity newDirector = movie.getDirector();

        if (movieName == null || newDirector == null || genre == null || releaseDate == null) {
            return new ResponseEntity<>(new InfoMessage("Your movie must have a director"), HttpStatus.BAD_REQUEST);
        }

        Long directorId = newDirector.getDirectorId();

        DirectorEntity director = directorService.getDirectorById(directorId);

        if (director == null) {
            return new ResponseEntity<>("Director was not found", HttpStatus.NOT_FOUND);
        }

        directorService.updateDirector(director);

        movie.setDirector(director);

        MovieEntity movieEntity = movieService.updateMovie(movie);

        if (movieEntity == null) {
            return new ResponseEntity<>(new InfoMessage("Movie Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(movieService.getMovieByName(movie.getName()), HttpStatus.CREATED);
    }

    // GET MOVIE
    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable Long movieId) {
        MovieEntity movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    // UPDATE MOVIE
    @PutMapping("/{movieId}")
    public ResponseEntity<?> updateMovie(@PathVariable Long movieId, @RequestBody MovieEntity movieObj) {
        String movieName = movieObj.getName();
        Genre genre = movieObj.getGenreType();
        double rating = movieObj.getRating();
        Date releaseDate = movieObj.getReleaseDate();
        DirectorEntity director = movieObj.getDirector();

        if (movieName == null || genre == null || director == null) {
            return new ResponseEntity<>(new InfoMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        DirectorEntity newDirector = directorService.getDirectorById(director.getDirectorId());

        if (newDirector == null) {
            return new ResponseEntity<>(new InfoMessage("Director was not found"), HttpStatus.BAD_REQUEST);
        }

        MovieEntity movie = movieService.getMovieById(movieId);

        if (movie == null) {
            return new ResponseEntity<>(new InfoMessage("Movie was not found"), HttpStatus.NOT_FOUND);
        }

        movie.setName(movieName);
        movie.setGenreType(genre);
        movie.setReleaseDate(releaseDate);
        movie.setDirector(newDirector);
        movie.setRating(rating);


        MovieEntity updatedMovie = movieService.updateMovie(movie);

        if (updatedMovie == null) {
            return new ResponseEntity<>(new InfoMessage("Update failed!"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    // DELETE MOVIE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (movieService.deleteMovie(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new InfoMessage("Movie was not deleted"), HttpStatus.BAD_REQUEST);
    }
}
    