package com.obss.movietracker.movietracker.springwebservice.Service;

import com.obss.movietracker.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public UserEntity getUserById(Long id) {
        UserEntity user = userRepository.findById(id).get();

        return user;
    }

    // Get All Users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity) {
        UserEntity user = userRepository.save(userEntity);
        System.out.println(user);
    }

    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();

        if (user == null) {
            return false;
        }

        userRepository.deleteById(id);

        return true;
    }

    // Search DB for existing user
    public boolean findExistingUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password) != null;
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Register new userEntity
    public boolean registerUser(UserEntity userEntity) {

        String hashedPassword = passwordService.hashPassword(userEntity.getPassword());

        userEntity.setPassword(hashedPassword);

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return savedUserEntity != null;
    }

}
