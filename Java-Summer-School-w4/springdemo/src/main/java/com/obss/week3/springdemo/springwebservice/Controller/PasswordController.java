package com.obss.week3.springdemo.springwebservice.Controller;

import com.obss.week3.springdemo.springwebservice.Form.Input;
import com.obss.week3.springdemo.springwebservice.Model.UserEntity;
import com.obss.week3.springdemo.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.week3.springdemo.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.week3.springdemo.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private UserService userService;


    // UPDATING PASSWORD ✔
    @PutMapping
    public ResponseEntity<?> changePassword(@RequestBody Input input) {
        String username = input.getUsername();
        String password = input.getPassword();

        if (username == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your username & password"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = userService.findUser(username);

        if (user == null) {
            return new ResponseEntity<>(new ErrorMessage("User not found"), HttpStatus.BAD_REQUEST);
        }

        String newPassword = input.getNewPassword();
        user.setPassword(newPassword);

        userService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Successfully updated"), HttpStatus.OK);
    }
}
