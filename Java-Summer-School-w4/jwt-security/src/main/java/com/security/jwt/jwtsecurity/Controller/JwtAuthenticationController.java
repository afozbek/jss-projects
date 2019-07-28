package com.security.jwt.jwtsecurity.Controller;

import com.security.jwt.jwtsecurity.Model.Jwt.JwtAuthenticationToken;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUser;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUserDetails;
import com.security.jwt.jwtsecurity.Service.JwtTokenUtilService;
import com.security.jwt.jwtsecurity.Service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtilService jwtTokenUtilService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @GetMapping
    public String getToken() {
        return "OK GET A TOKEN 😊";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtUser jwtUser) {
        // CHECK USER IN THE DATABASE
        JwtUserDetails jwtUserDetails = (JwtUserDetails) jwtUserDetailsService.loadUserByUsername(jwtUser.getUsername());

        String token = jwtTokenUtilService.generateToken(jwtUserDetails);

        return ResponseEntity.ok(new JwtAuthenticationToken(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody JwtUser jwtUser) throws Exception {
        return ResponseEntity.ok(jwtUserDetailsService.save(jwtUser));
    }
}