package com.obss.movietracker.springwebservice.Service;


import com.obss.movietracker.springwebservice.Model.Jwt.JwtUser;
import com.obss.movietracker.springwebservice.Model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity saveUser(JwtUser jwtUser);

    UserEntity saveUser(UserEntity jwtUser);

    boolean deleteUser(Long id);

    UserEntity deleteUserByUsername(String username);

    boolean findExistingUser(String username, String password);

    UserEntity findUserByUsername(String username);

    UserEntity findUserByUsernameAndPassword(String username, String password);

    boolean registerUser(UserEntity userEntity);
}
