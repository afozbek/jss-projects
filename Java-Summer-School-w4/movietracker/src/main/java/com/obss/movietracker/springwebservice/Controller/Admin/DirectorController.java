package com.obss.movietracker.springwebservice.Controller.Admin;

import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.DirectorService;
import com.obss.movietracker.springwebservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private MovieService movieService;

    // GET DIRECTOR OR DIRECTORS
    @GetMapping
    public ResponseEntity<?> getDirectors(@RequestParam(required = false, name = "director") String directorName) {

        List<DirectorEntity> movies = directorService.getDirectorByName(directorName);

        if (movies.size() == 0) {
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // POST DIRECTOR
    @PostMapping
    public ResponseEntity<?> createDirector(@RequestBody DirectorEntity director) {
        if (director.getName() == null || director.getSurname() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill fields"), HttpStatus.BAD_REQUEST);
        }

        if (!directorService.updateDirector(director)) {
            return new ResponseEntity<>(new ErrorMessage("Director Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(new InfoMessage("Director creation success 😊"), HttpStatus.CREATED);
    }

    // UPDATE DIRECTOR
    @PutMapping
    public ResponseEntity<?> updateDirector(@RequestBody DirectorEntity director) {
        String directorName = director.getName();
        String surname = director.getSurname();
        Date birthDate = director.getBirthDate();

        if (directorName == null || surname == null || birthDate == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        List<DirectorEntity> directors = directorService.getDirectorByName(directorName);

        if (directors == null) {
            return new ResponseEntity<>(new InfoMessage("Movies not found"), HttpStatus.NOT_FOUND);
        }

        director.setName(directorName);
        director.setSurname(surname);
        director.setBirthDate(birthDate);

        if (!directorService.updateDirector(director)) {
            return new ResponseEntity<>(new ErrorMessage("Update failed!"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(new InfoMessage("Update successfull 😊"), HttpStatus.OK);
    }

    // DELETE DIRECTOR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable Long id) {
        if (directorService.deleteDirector(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Director was not deleted"), HttpStatus.BAD_REQUEST);
    }
}
