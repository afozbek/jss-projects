package com.obss.movietracker.springwebservice.Controller.Auth;

import com.obss.movietracker.springwebservice.Form.PasswordChangeForm;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Notifications.Messages.ErrorMessage;
import com.obss.movietracker.springwebservice.Notifications.Messages.InfoMessage;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/password")
public class PasswordController {

    @Autowired
    private UserService adminService;

    // UPDATING PASSWORD ✔
    @PutMapping
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeForm passwordChangeForm) {
        String email = passwordChangeForm.getEmail();
        String password = passwordChangeForm.getPassword();

        if (email == null || password == null) {
            return new ResponseEntity<>(new ErrorMessage("Please enter your username & password"), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = adminService.findUserByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(new ErrorMessage("Public not found"), HttpStatus.BAD_REQUEST);
        }

        String newPassword = passwordChangeForm.getNewPassword();
        user.setPassword(newPassword);

        adminService.saveUser(user);

        return new ResponseEntity<>(new InfoMessage("Successfully updated"), HttpStatus.OK);
    }
}
