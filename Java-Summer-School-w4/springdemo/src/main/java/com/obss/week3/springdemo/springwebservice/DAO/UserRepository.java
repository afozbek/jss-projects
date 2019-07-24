package com.obss.week3.springdemo.springwebservice.DAO;

import com.obss.week3.springdemo.springwebservice.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Override
    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndPassword(String username, String password);
}
