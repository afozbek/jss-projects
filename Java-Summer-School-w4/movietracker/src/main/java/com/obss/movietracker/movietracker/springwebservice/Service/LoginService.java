package com.obss.movietracker.movietracker.springwebservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserService adminService;

    @Autowired
    private PasswordService passwordService;

    public boolean login(String username, String password) {
        String hashedPassword = passwordService.hashPassword(password);

        return adminService.findExistingUser(username, hashedPassword);
    }
}
