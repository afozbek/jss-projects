package com.obss.movietracker.springwebservice.Service.Util;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PasswordService {
    public String hashPassword(String password) {

        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        System.out.println(hashedPassword);

        return hashedPassword;
    }
}
