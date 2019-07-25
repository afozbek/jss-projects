package com.obss.movietracker.movietracker.springwebservice.Controller;

import com.obss.movietracker.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.movietracker.springwebservice.Service.List.FavListService;
import com.obss.movietracker.movietracker.springwebservice.Service.List.WatchListService;
import com.obss.movietracker.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavListService favListService;

    @Autowired
    private WatchListService watchListService;

    @GetMapping("/{id}/favlist")
    public List<MovieEntity> getFavorites(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return null;
        }

        return favListService.getFavList(user);
    }

    @GetMapping("/{id}/watchlist")
    public List<MovieEntity> getWatchList(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return null;
        }

        return watchListService.getWatchList(user);
    }
}
