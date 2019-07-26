package com.obss.movietracker.springwebservice.Controller.Admin;

import com.google.common.hash.Hashing;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

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
    @PutMapping("/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody UserEntity userEntity) {
        String newEmail = userEntity.getEmail();
        String newPassword = userEntity.getPassword();
        String newFirstName = userEntity.getFirstName();
        String newLastName = userEntity.getLastName();

        UserEntity user = userService.findUserByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(new InfoMessage("User was not found"), HttpStatus.NOT_FOUND);
        }

        if (newEmail == null || newPassword == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        String hashedPassword = Hashing.sha256().hashString(newPassword, StandardCharsets.UTF_8).toString();

        user.setEmail(newEmail);
        user.setPassword(hashedPassword);

        if (newFirstName != null || newLastName != null) {
            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
        }

        userService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Update success 😊"), HttpStatus.OK);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(new InfoMessage("Successfully deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("Public was not deleted"), HttpStatus.BAD_REQUEST);
    }

}
