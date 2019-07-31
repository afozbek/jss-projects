package com.obss.movietracker.springwebservice.Controller.Admin;

import com.obss.movietracker.springwebservice.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Impl.UserServiceImpl;
import com.obss.movietracker.springwebservice.Service.Impl.Util.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordServiceImpl passwordService;

    // GET USER OR USERS ✔
    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam(required = false, name = "username") String username) {

        UserEntity userEntity = userService.findUserByUsername(username);

        if (userEntity == null) {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    // CREATE USER ✔
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        if (userEntity.getUsername() == null || userEntity.getPassword() == null) {
            return new ResponseEntity<>(new InfoMessage("Please enter your email and password"), HttpStatus.BAD_REQUEST);
        }

        if (!userService.registerUser(userEntity)) {
            return new ResponseEntity<>(new InfoMessage("UserEntity Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    // UPDATE USER
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody UserEntity userEntity) {
        String newUsername = userEntity.getUsername();
        String newPassword = userEntity.getPassword();
        String newFirstName = userEntity.getFirstName();
        String newLastName = userEntity.getLastName();

        UserEntity user = userService.findUserByUsername(username);

        if (user == null) {
            return new ResponseEntity<>(new InfoMessage("User was not found"), HttpStatus.NOT_FOUND);
        }

        if (newUsername == null || newPassword == null) {
            return new ResponseEntity<>(new InfoMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        String newHashedPassword = passwordService.hashPassword(newPassword);

        user.setUsername(newUsername);
        user.setPassword(newHashedPassword);

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

        return new ResponseEntity<>(new InfoMessage("Public was not deleted"), HttpStatus.BAD_REQUEST);
    }
}
