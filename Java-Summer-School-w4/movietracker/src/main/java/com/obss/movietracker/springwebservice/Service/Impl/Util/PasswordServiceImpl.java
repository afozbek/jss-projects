package com.obss.movietracker.springwebservice.Service.Impl.Util;

import com.google.common.hash.Hashing;
import com.obss.movietracker.springwebservice.Service.PasswordService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PasswordServiceImpl implements PasswordService {

    public String hashPassword(String password) {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
