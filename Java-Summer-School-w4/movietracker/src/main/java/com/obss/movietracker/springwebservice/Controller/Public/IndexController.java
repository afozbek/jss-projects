package com.obss.movietracker.springwebservice.Controller.Public;

import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Service.MovieService;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class IndexController {
    // GET MOVIE OR MOVIES

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    // GET MOVIE OR MOVIES
    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(required = false, name = "movie") String movieName,
                                       @RequestParam(required = false, name = "genre") Genre genre) {
        List<MovieEntity> movieList;

        if (movieName != null && genre != null) {
            movieList = movieService.getMovieByNameAndGenre(movieName, genre);

        } else if (movieName != null) {
            movieList = movieService.getMovieByName(movieName);

        } else if (genre != null) {
            movieList = movieService.getMovieByGenre(genre);

        } else {
            movieList = movieService.getMovies();
        }
        if (movieList == null) {
            return new ResponseEntity<>(new ErrorMessage("Can not retrieve movieList"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping("/favList")
    public ResponseEntity<?> addToFavList(Long userId, Long movieId) {
        Set<MovieEntity> favList = userService.addMovieToFavList(userId, movieId);

        if (favList == null) {
            return new ResponseEntity<>(new ErrorMessage("Posting to favList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(favList, HttpStatus.CREATED);
    }

    @PostMapping("/watchList")
    public ResponseEntity<?> addToWatchList(Long userId, Long movieId) {
        Set<MovieEntity> watchList = userService.addMovieToWatchList(userId, movieId);

        if (watchList == null) {
            return new ResponseEntity<>(new ErrorMessage("Posting to watchList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(watchList, HttpStatus.CREATED);
    }

}
