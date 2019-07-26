package com.obss.movietracker.springwebservice.DAO;

import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.Types.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

    @Override
    List<MovieEntity> findAll();

    List<MovieEntity> findByName(String movieName);

    List<MovieEntity> findByDirectorDirectorId(Long directorId);

    List<MovieEntity> findByNameAndGenre(String name, Genre genre);

    List<MovieEntity> findByGenre(Genre genre);
}
