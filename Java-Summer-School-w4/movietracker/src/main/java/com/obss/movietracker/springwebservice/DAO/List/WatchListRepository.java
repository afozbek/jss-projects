package com.obss.movietracker.springwebservice.DAO.List;

import com.obss.movietracker.springwebservice.Model.List.WatchListEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WatchListRepository extends CrudRepository<WatchListEntity, Long> {
    List<WatchListEntity> findAllByUser(UserEntity userId);
}
