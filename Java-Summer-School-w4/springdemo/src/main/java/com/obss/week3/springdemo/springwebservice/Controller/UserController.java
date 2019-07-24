package com.obss.week3.springdemo.springwebservice.Controller;

import com.obss.week3.springdemo.springwebservice.Model.UserEntity;
import com.obss.week3.springdemo.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.week3.springdemo.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GETTING USER OR USERS ✔
    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam(required = false, name = "username") String username) {

        UserEntity userEntity = userService.findUser(username);

        if (userEntity == null) {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    // CREATING USER ✔
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

    // DISABLED USER ✔
    @PutMapping
    public ResponseEntity<?> disableUser(String username) {
        UserEntity user = userService.findUser(username);

        if (user == null) {
            return new ResponseEntity<>(new ErrorMessage("User not found"), HttpStatus.BAD_REQUEST);
        }

        user.setStatus(false);

        userService.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
