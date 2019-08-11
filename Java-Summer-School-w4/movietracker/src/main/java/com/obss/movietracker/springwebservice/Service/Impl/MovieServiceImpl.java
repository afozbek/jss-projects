package com.obss.movietracker.springwebservice.Service.Impl;

import com.obss.movietracker.springwebservice.DAO.MovieRepository;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import com.obss.movietracker.springwebservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    public List<MovieEntity> getMovieByName(String movieName) {
        return movieRepository.findByName(movieName);
    }

    public List<MovieEntity> getDirectorsMovies(Long directorId) {
        return movieRepository.findByDirectorDirectorId(directorId);
    }

    public MovieEntity updateMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

    public boolean deleteMovie(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElse(null);

        if (movie == null) {
            return false;
        }

        movieRepository.deleteById(id);

        return true;
    }

    public MovieEntity getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public List<MovieEntity> getMovieByNameAndGenre(String movieName, Genre genre) {
        return movieRepository.findByNameAndGenre(movieName, genre);
    }

    public List<MovieEntity> getMovieByGenre(Genre genre) {
        return movieRepository.findByGenre(genre);
    }
}
