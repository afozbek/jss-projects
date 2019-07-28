package com.security.jwt.jwtsecurity.Service;

import com.security.jwt.jwtsecurity.DAO.UserRepository;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUser;
import com.security.jwt.jwtsecurity.Model.Jwt.JwtUserDetails;
import com.security.jwt.jwtsecurity.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with this username: " + username);
        }

        return new JwtUserDetails(username, user.getPassword(), new ArrayList<>());
    }

    public UserEntity save(JwtUser user) {
        UserEntity newUser = new UserEntity();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordService.hashPassword(user.getPassword()));

        return userRepository.save(newUser);
    }
}
