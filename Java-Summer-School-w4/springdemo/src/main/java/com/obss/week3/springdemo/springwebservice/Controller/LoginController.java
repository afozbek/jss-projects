package com.obss.week3.springdemo.springwebservice.Controller;

import com.obss.week3.springdemo.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.week3.springdemo.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.week3.springdemo.springwebservice.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // LOGIN USER
    @PostMapping
    public ResponseEntity<?> login(String username, String password) {
        if (username == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        if (loginService.login(username, password)) {
            System.out.println("You can login now");
            return new ResponseEntity<>(new InfoMessage("A big welcome 😊 " + username), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ErrorMessage("username or password wrong"), HttpStatus.NOT_FOUND);
    }
}
