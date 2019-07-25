package com.obss.movietracker.springwebservice.DAO.List;

import com.obss.movietracker.springwebservice.Model.List.FavListEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavListRepository extends CrudRepository<FavListEntity, Long> {

    List<FavListEntity> findAllByUser(UserEntity userId);
}
