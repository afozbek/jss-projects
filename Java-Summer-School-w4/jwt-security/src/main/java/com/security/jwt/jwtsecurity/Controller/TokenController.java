package com.security.jwt.jwtsecurity.Controller;

import com.security.jwt.jwtsecurity.Model.JwtUser;
import com.security.jwt.jwtsecurity.Security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping
    public String getToken() {
        return "OK GET A TOKEN 😊";
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
