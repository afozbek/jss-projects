package com.obss.movietracker.springwebservice.Service.Jwt;

import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUser;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUserDetails;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Util.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


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

        return new JwtUserDetails(user.getUserId(), username, user.getPassword(), user.getAuthorities());
    }

    // Search DB for existing user
    public UserDetails loadUserByUsernameAndPassword(String username, String password) throws UsernameNotFoundException {
        String hashedPassword = passwordService.hashPassword(password);

        UserEntity user = userRepository.findByUsernameAndPassword(username, hashedPassword);

        if (user == null) {
            throw new UsernameNotFoundException("Username or password wrong");
        }

        return new JwtUserDetails(user.getUserId(), username, user.getPassword(), user.getAuthorities());
    }


    public UserEntity saveUser(JwtUser jwtUser) throws NullPointerException {
        UserEntity userEntity = new UserEntity();

        try {
            userEntity.setUsername(jwtUser.getUsername());
            userEntity.setPassword(passwordService.hashPassword(jwtUser.getPassword()));
            userEntity.setAuthorities(jwtUser.getAuthorities());

        } catch (NullPointerException ex) {
            return null;
        }

        return userRepository.save(userEntity);
    }
}
