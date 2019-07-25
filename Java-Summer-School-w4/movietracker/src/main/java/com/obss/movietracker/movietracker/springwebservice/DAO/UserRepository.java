package com.obss.movietracker.movietracker.springwebservice.DAO;

import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Override
    List<UserEntity> findAll();

    UserEntity findByEmail(String email);

    UserEntity findByEmailAndPassword(String email, String password);
}
