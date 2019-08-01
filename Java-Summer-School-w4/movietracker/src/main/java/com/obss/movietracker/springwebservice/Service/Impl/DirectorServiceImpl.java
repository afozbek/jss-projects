package com.obss.movietracker.springwebservice.Service.Impl;

import com.obss.movietracker.springwebservice.DAO.DirectorRepository;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<DirectorEntity> getDirectors() {
        return directorRepository.findAll();
    }

    public DirectorEntity getDirectorById(Long directorId) {
        if (directorId == null) {
            return null;
        }
        return directorRepository.findById(directorId).orElse(null);
    }

    public List<DirectorEntity> getDirectorByName(String directorName) {
        return directorRepository.findByName(directorName);
    }

    public DirectorEntity updateDirector(DirectorEntity directorEntity) {
        return directorRepository.save(directorEntity);
    }

    public boolean deleteDirector(Long id) {
        DirectorEntity director = directorRepository.findById(id).orElse(null);

        if (director == null) {
            return false;
        }

        directorRepository.deleteById(id);

        return true;
    }
}
