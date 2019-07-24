package com.obss.week3.springdemo.springwebservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserService userService;

    public boolean login(String username, String password) {
        return userService.findExistingUser(username, password);
    }
}
