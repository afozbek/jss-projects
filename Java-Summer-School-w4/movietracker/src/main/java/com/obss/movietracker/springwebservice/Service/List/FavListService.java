package com.obss.movietracker.springwebservice.Service.List;

import com.obss.movietracker.springwebservice.DAO.List.FavListRepository;
import com.obss.movietracker.springwebservice.Model.List.FavListEntity;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavListService {

    @Autowired
    private FavListRepository favListRepository;

    public List<MovieEntity> getFavList(UserEntity user) {
        List<FavListEntity> favList = favListRepository.findAllByUser(user);

        List<MovieEntity> movieList = new ArrayList<>();

        for (FavListEntity favListEntity : favList) {
            movieList.add(favListEntity.getMovie());
        }

        return movieList;
    }
}
