package com.obss.movietracker.springwebservice.Service;

import com.obss.movietracker.springwebservice.DAO.MovieRepository;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

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

    public boolean updateMovie(MovieEntity movieEntity, DirectorEntity director) {
        movieEntity.setDirector(director);

        MovieEntity savedMovie = movieRepository.save(movieEntity);

        return savedMovie != null;
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
