package com.obss.movietracker.springwebservice.Controller.Auth;

import com.obss.movietracker.springwebservice.Form.PasswordChangeForm;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtAuthenticationToken;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUser;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUserDetails;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.Jwt.JwtTokenUtilService;
import com.obss.movietracker.springwebservice.Service.Jwt.JwtUserDetailsService;
import com.obss.movietracker.springwebservice.Service.UserService;
import com.obss.movietracker.springwebservice.Service.Util.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    // LOGIN USER ✔
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtUser jwtUser) {

        if (jwtUser.getUsername() == null || jwtUser.getPassword() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please fill the form"), HttpStatus.BAD_REQUEST);
        }

        JwtUserDetails jwtUserDetails;

        try {
            jwtUserDetails = (JwtUserDetails) jwtUserDetailsService
                    .loadUserByUsernameAndPassword(jwtUser.getUsername(), jwtUser.getPassword());

        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>(new ErrorMessage("Username or password wrong"), HttpStatus.BAD_REQUEST);
        }

        String token = jwtTokenUtilService.generateToken(jwtUserDetails);

        return ResponseEntity.ok(new JwtAuthenticationToken(token, jwtUserDetails.getAuthorities()));
    }

    // CREATE USER ✔
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody JwtUser jwtUser) {
        if (jwtUser.getUsername() == null || jwtUser.getPassword() == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your username and password"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = jwtUserDetailsService.saveUser(jwtUser);

        if (user == null) {
            return new ResponseEntity<>(new ErrorMessage("User Creation failed"), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // UPDATING PASSWORD ✔
    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeForm passwordChangeForm) {
        String username = passwordChangeForm.getUsername();
        String password = passwordChangeForm.getPassword();

        if (username == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your username & password"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = userService.findUserByUsernameAndPassword(username, password);

        if (user == null) {
            return new ResponseEntity<>(new ErrorMessage("User is not found"), HttpStatus.BAD_REQUEST);
        }

        String newPassword = passwordChangeForm.getNewPassword();
        String hashedNewPassword = passwordService.hashPassword(newPassword);

        user.setPassword(hashedNewPassword);

        userService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Successfully updated"), HttpStatus.OK);
    }
}
