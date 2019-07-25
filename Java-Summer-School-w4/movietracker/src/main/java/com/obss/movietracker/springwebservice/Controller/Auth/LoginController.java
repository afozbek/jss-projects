package com.obss.movietracker.springwebservice.Controller.Auth;

import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // LOGIN USER
    @PostMapping
    public ResponseEntity<?> login(String email, String password) {
        if (email == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        if (loginService.login(email, password)) {
            System.out.println("You can login now");
            return new ResponseEntity<>(new InfoMessage("A big welcome 😊 " + email), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("username or password wrong"), HttpStatus.NOT_FOUND);
    }
}
