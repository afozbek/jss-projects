package com.obss.movietracker.springwebservice.Controller.Admin;

import com.google.common.hash.Hashing;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.List.FavListService;
import com.obss.movietracker.springwebservice.Service.List.WatchListService;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavListService favListService;

    @Autowired
    private WatchListService watchListService;

    // GET USER OR USERS ✔
    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam(required = false, name = "email") String email) {

        UserEntity userEntity = userService.findUserByEmail(email);

        if (userEntity == null) {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    // CREATE USER ✔
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        if (userEntity.getEmail() == null || userEntity.getPassword() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your email and password"), HttpStatus.BAD_REQUEST);
        }

        if (!userService.registerUser(userEntity)) {
            return new ResponseEntity<>(new ErrorMessage("UserEntity Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    // UPDATE USER
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity) {
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        String firstName = userEntity.getFirstName();
        String lastName = userEntity.getLastName();

        if (email == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = userService.findUserByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(new InfoMessage("Public not found"), HttpStatus.NOT_FOUND);
        }

        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        user.setEmail(email);
        user.setPassword(hashedPassword);

        if (firstName != null || lastName != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
        }

        userService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Update successfull 😊"), HttpStatus.OK);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Public was not deleted"), HttpStatus.BAD_REQUEST);
    }

    // GET FAVLIST ?
    @GetMapping("/{id}/favlist")
    public List<MovieEntity> getFavorites(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return null;
        }

        return favListService.getFavList(user);
    }

    // GET WATCHLIST ?
    @GetMapping("/{id}/watchlist")
    public List<MovieEntity> getWatchList(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return null;
        }

        return watchListService.getWatchList(user);
    }
}
