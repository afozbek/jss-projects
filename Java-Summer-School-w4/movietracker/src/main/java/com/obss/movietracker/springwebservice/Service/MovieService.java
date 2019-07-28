package com.obss.movietracker.springwebservice.Service;

import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;

import java.util.List;

public interface MovieService {

    List<MovieEntity> getMovies();

    List<MovieEntity> getMovieByName(String movieName);

    List<MovieEntity> getDirectorsMovies(Long directorId);

    boolean updateMovie(MovieEntity movieEntity, DirectorEntity director);

    boolean deleteMovie(Long id);

    MovieEntity getMovieById(Long movieId);

    List<MovieEntity> getMovieByNameAndGenre(String movieName, Genre genre);

    List<MovieEntity> getMovieByGenre(Genre genre);
}
