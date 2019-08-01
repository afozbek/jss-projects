package com.obss.movietracker.springwebservice.Service;

import com.obss.movietracker.springwebservice.Model.DirectorEntity;

import java.util.List;

public interface DirectorService {

    List<DirectorEntity> getDirectors();

    DirectorEntity getDirectorById(Long directorId);

    List<DirectorEntity> getDirectorByName(String directorName);

    DirectorEntity updateDirector(DirectorEntity directorEntity);

    boolean deleteDirector(Long id);
}
