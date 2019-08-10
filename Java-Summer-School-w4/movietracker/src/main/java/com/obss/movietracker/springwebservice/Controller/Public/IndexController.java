package com.obss.movietracker.springwebservice.Controller.Public;

import com.obss.movietracker.springwebservice.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Impl.MovieServiceImpl;
import com.obss.movietracker.springwebservice.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> hello() {
        return new ResponseEntity<>(new InfoMessage("Hello World"), HttpStatus.OK);
    }

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
            if (genre == Genre.ALL_MOVIES) {
                movieList = movieService.getMovies();
            } else {
                movieList = movieService.getMovieByGenre(genre);
            }

        } else {
            movieList = movieService.getMovies();
        }
        if (movieList == null) {
            return new ResponseEntity<>(new InfoMessage("Can not retrieve movieList"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/{username}/favList")
    public ResponseEntity<?> getFavList(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username);

        Set<MovieEntity> favLists = user.getFavList();

        return new ResponseEntity<>(favLists, HttpStatus.OK);
    }

    @DeleteMapping("/{username}/favList/{movieId}")
    public ResponseEntity<?> deleteFromFavList(@PathVariable String username, @PathVariable Long movieId) {
        UserEntity user = userService.getUserByUsername(username);

        Set<MovieEntity> favLists = user.getFavList();

        Set<MovieEntity> newFavList = new HashSet<>();

        for (MovieEntity movie : favLists) {
            if (movie.getMovieId().equals(movieId)) {
                continue;
            }
            newFavList.add(movie);
        }

        user.setFavList(newFavList);

        UserEntity updatedUser = userService.saveUser(user);

        return new ResponseEntity<>(updatedUser.getFavList(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/favList/{movieId}")
    public ResponseEntity<?> addToFavList(@PathVariable Long userId, @PathVariable Long movieId) {
        Set<MovieEntity> favList = userService.addMovieToFavList(userId, movieId);

        if (favList == null) {
            return new ResponseEntity<>(new InfoMessage("Posting to favList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(favList, HttpStatus.CREATED);
    }

    @GetMapping("/{username}/watchList")
    public ResponseEntity<?> getWatchList(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username);

        Set<MovieEntity> watchList = user.getWatchList();

        return new ResponseEntity<>(watchList, HttpStatus.OK);
    }

    @DeleteMapping("/{username}/watchList/{movieId}")
    public ResponseEntity<?> deleteFromWatchList(@PathVariable String username, @PathVariable Long movieId) {
        UserEntity user = userService.getUserByUsername(username);

        Set<MovieEntity> watchList = user.getWatchList();

        Set<MovieEntity> newWatchList = new HashSet<>();

        for (MovieEntity movie : watchList) {
            if (movie.getMovieId().equals(movieId)) {
                continue;
            }
            newWatchList.add(movie);
        }

        user.setWatchList(newWatchList);

        UserEntity updatedUser = userService.saveUser(user);

        return new ResponseEntity<>(updatedUser.getWatchList(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/watchList/{movieId}")
    public ResponseEntity<?> addToWatchList(@PathVariable Long userId, @PathVariable Long movieId) {
        Set<MovieEntity> wathcList = userService.addMovieToWatchList(userId, movieId);

        if (wathcList == null) {
            return new ResponseEntity<>(new InfoMessage("Posting to favList failed 😢"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(wathcList, HttpStatus.CREATED);
    }

}
