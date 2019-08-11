package com.obss.movietracker.springwebservice.Controller.Admin;

import com.obss.movietracker.springwebservice.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Model.DirectorEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Service.Impl.DirectorServiceImpl;
import com.obss.movietracker.springwebservice.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/admin/director")
public class DirectorController {

    @Autowired
    private DirectorServiceImpl directorService;

    @Autowired
    private MovieServiceImpl movieService;

    // GET DIRECTOR OR DIRECTORS
    @GetMapping
    public ResponseEntity<?> getDirectors(@RequestParam(required = false, name = "director") String directorName) {

        if (directorName == null) {
            return new ResponseEntity<>(directorService.getDirectors(), HttpStatus.OK);
        }

        List<DirectorEntity> directors = directorService.getDirectorByName(directorName);

        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    // GET MOVIE
    @GetMapping("/{directorId}")
    public ResponseEntity<?> getDirector(@PathVariable Long directorId) {
        DirectorEntity director = directorService.getDirectorById(directorId);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    // POST DIRECTOR
    @PostMapping
    public ResponseEntity<?> createDirector(@RequestBody DirectorEntity director) {

        if (director.getName() == null || director.getSurname() == null) {
            return new ResponseEntity<>(new InfoMessage("Please fill fields"), HttpStatus.BAD_REQUEST);
        }

        DirectorEntity newDirector = directorService.updateDirector(director);

        if (newDirector == null) {
            return new ResponseEntity<>(new InfoMessage("Director Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
    }

    // UPDATE DIRECTOR
    @PutMapping("/{directorId}")
    public ResponseEntity<?> updateDirector(@PathVariable Long directorId, @RequestBody DirectorEntity directorObj) {

        String directorName = directorObj.getName();
        String surname = directorObj.getSurname();
        String birthPlace = directorObj.getBirthPlace();
        Date birthDate = directorObj.getBirthDate();

        if (directorName == null || surname == null || birthPlace == null || birthDate==null) {
            return new ResponseEntity<>(new InfoMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        DirectorEntity newDirector = directorService.getDirectorById(directorId);

        if (newDirector == null) {
            return new ResponseEntity<>(new InfoMessage("Director was not found"), HttpStatus.NOT_FOUND);
        }

        newDirector.setDirectorId(directorId);
        newDirector.setName(directorName);
        newDirector.setSurname(surname);
        newDirector.setBirthPlace(birthPlace);
        newDirector.setBirthDate(birthDate);

        DirectorEntity updatedDirector = directorService.updateDirector(newDirector);

        if (updatedDirector == null) {
            return new ResponseEntity<>(new InfoMessage("Update failed!"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(updatedDirector, HttpStatus.OK);
    }

    // DELETE DIRECTOR
    @DeleteMapping("/{directorId}")
    public ResponseEntity<?> deleteDirector(@PathVariable Long directorId) {
        if (directorService.deleteDirector(directorId)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new InfoMessage("Director was not deleted"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{directorId}/movies")
    public ResponseEntity<?> getDirectorMovies(@PathVariable Long directorId) {
        List<MovieEntity> directorMovies = movieService.getDirectorsMovies(directorId);

        if (directorMovies == null) {
            return new ResponseEntity<>(new InfoMessage("Director or movies not found"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(directorMovies, HttpStatus.OK);
    }
}
