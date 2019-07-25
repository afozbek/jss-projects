package com.obss.movietracker.springwebservice.Controller.Public;

import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Service.MovieService;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController {
    // GET MOVIE OR MOVIES

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(required = false, name = "movie") String movieName) {

        List<MovieEntity> movies = movieService.getMovieByName(movieName);

        if (movies.size() == 0) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/favList")
    public ResponseEntity<?> addToFavList(Long userId, Long movieId) {
        Map<Long, MovieEntity> favList = userService.addMovieToFavList(userId, movieId);

        if (favList == null) {
            return new ResponseEntity<>(new ErrorMessage("Posting to favList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(favList, HttpStatus.CREATED);
    }

    @PostMapping("/watchList")
    public ResponseEntity<?> addToWatchList(Long userId, Long movieId) {
        Map<Long, MovieEntity> watchList = userService.addMovieToWatchList(userId, movieId);

        if (watchList == null) {
            return new ResponseEntity<>(new ErrorMessage("Posting to watchList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(watchList, HttpStatus.CREATED);
    }

}
