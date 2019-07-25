package com.obss.movietracker.springwebservice.Service;

import com.obss.movietracker.springwebservice.DAO.MovieRepository;
import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private MovieRepository movieRepository;

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

    public Map<Long, MovieEntity> addMovieToFavList(Long userId, Long movieId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return null;
        }

        Map<Long, MovieEntity> favList = user.getFavList();
        favList.put(movieId, movie);

        user.setFavList(favList);

        UserEntity savedUser = userRepository.save(user);

        return favList;
    }

    public Map<Long, MovieEntity> addMovieToWatchList(Long userId, Long movieId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return null;
        }

        Map<Long, MovieEntity> watchList = user.getWatchList();
        watchList.put(movieId, movie);

        user.setWatchList(watchList);

        UserEntity savedUser = userRepository.save(user);

        return watchList;
    }
}
