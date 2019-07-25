package com.obss.movietracker.springwebservice.DAO;

import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Long> {
    @Override
    List<DirectorEntity> findAll();

    List<DirectorEntity> findByName(String directorName);
}
