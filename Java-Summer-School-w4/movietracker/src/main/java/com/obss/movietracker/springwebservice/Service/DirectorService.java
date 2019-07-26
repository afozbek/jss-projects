package com.obss.movietracker.springwebservice.Service;

import com.obss.movietracker.springwebservice.DAO.DirectorRepository;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public List<DirectorEntity> getDirectors() {
        return directorRepository.findAll();
    }

    public DirectorEntity getDirectorById(Long directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }

    public List<DirectorEntity> getDirectorByName(String directorName) {
        return directorRepository.findByName(directorName);
    }

    public boolean updateDirector(DirectorEntity directorEntity) {

        DirectorEntity saveDirector = directorRepository.save(directorEntity);

        return saveDirector != null;
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
