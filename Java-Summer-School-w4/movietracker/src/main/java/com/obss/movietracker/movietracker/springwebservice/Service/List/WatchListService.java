package com.obss.movietracker.movietracker.springwebservice.Service.List;

import com.obss.movietracker.movietracker.springwebservice.DAO.List.WatchListRepository;
import com.obss.movietracker.movietracker.springwebservice.Model.List.WatchListEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchListService {

    @Autowired
    private WatchListRepository watchListRepository;

    public List<MovieEntity> getWatchList(UserEntity user) {
        List<WatchListEntity> watchList = watchListRepository.findAllByUser(user);

        List<MovieEntity> movieList = new ArrayList<>();

        for (WatchListEntity watchListEntity : watchList) {
            movieList.add(watchListEntity.getMovie());
        }

        return movieList;
    }
}
