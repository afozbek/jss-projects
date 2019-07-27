package com.security.jwt.jwtsecurity.Controller;

import com.security.jwt.jwtsecurity.Model.JwtAuthenticationToken;
import com.security.jwt.jwtsecurity.Model.JwtUser;
import com.security.jwt.jwtsecurity.Service.JwtTokenUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    @GetMapping
    public String getToken() {
        return "OK GET A TOKEN 😊";
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody JwtUser jwtUser) {
        // CHECK USER IN THE DATABASE
        String token = jwtTokenUtilService.generateToken(jwtUser);
        return ResponseEntity.ok(new JwtAuthenticationToken(token));
    }
}
