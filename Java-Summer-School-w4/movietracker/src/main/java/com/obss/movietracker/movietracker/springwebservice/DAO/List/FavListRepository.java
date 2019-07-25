package com.obss.movietracker.movietracker.springwebservice.DAO.List;

import com.obss.movietracker.movietracker.springwebservice.Model.List.FavListEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavListRepository extends CrudRepository<FavListEntity, Long> {

    List<FavListEntity> findAllByUser(UserEntity userId);
}
