package com.obss.movietracker.springwebservice.Service.Auth;

import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserService adminService;

    @Autowired
    private PasswordService passwordService;

    public boolean login(String email, String password) {
        String hashedPassword = passwordService.hashPassword(password);

        return adminService.findExistingUser(email, hashedPassword);
    }
}
