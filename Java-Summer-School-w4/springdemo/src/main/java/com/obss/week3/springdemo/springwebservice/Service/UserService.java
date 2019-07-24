package com.obss.week3.springdemo.springwebservice.Service;

import com.obss.week3.springdemo.springwebservice.DAO.UserRepository;
import com.obss.week3.springdemo.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    // Search DB for existing user
    public boolean findExistingUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    public UserEntity findUser(String username) {
        return userRepository.findByUsername(username);
    }

    // Register new userEntity
    public boolean registerUser(UserEntity userEntity) {
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return savedUserEntity != null;
    }
}
