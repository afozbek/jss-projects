package com.obss.movietracker.springwebservice.Service.Impl;

import com.obss.movietracker.springwebservice.DAO.MovieRepository;
import com.obss.movietracker.springwebservice.DAO.UserRepository;
import com.obss.movietracker.springwebservice.Exceptions.PasswordWrongException;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUser;
import com.obss.movietracker.springwebservice.Model.Jwt.JwtUserDetails;
import com.obss.movietracker.springwebservice.Model.MovieEntity;
import com.obss.movietracker.springwebservice.Model.UserEntity;
import com.obss.movietracker.springwebservice.Service.Impl.Util.PasswordServiceImpl;
import com.obss.movietracker.springwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordServiceImpl passwordService;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with this username: " + username);
        }

        return new JwtUserDetails(user.getUserId(), username, user.getPassword(), user.getAuthorities());
    }

    // Search DB for existing user
    public UserDetails loadUserByUsernameAndPassword(String username, String password) throws UsernameNotFoundException, PasswordWrongException {
        String hashedPassword = passwordService.hashPassword(password);

        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username or password wrong");
        }

        try {
            if (!user.getPassword().equals(hashedPassword)) {
                throw new PasswordWrongException("Password is wrong");
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        return new JwtUserDetails(user.getUserId(), username, user.getPassword(), user.getAuthorities());
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Get All Users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(JwtUser jwtUser) throws NullPointerException {
        UserEntity userEntity = new UserEntity();

        try {
            userEntity.setUsername(jwtUser.getUsername());
            userEntity.setPassword(passwordService.hashPassword(jwtUser.getPassword()));
            userEntity.setFirstName(jwtUser.getFirstName());
            userEntity.setLastName(jwtUser.getLastName());
            userEntity.setAuthorities(jwtUser.getAuthorities());

        } catch (NullPointerException ex) {
            return null;
        }

        return userRepository.save(userEntity);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return false;
        }

        userRepository.deleteById(id);

        return true;
    }

    public UserEntity findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Search DB for existing user
    public boolean findExistingUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    // Register new userEntity
    public boolean registerUser(UserEntity userEntity) {

        String hashedPassword = passwordService.hashPassword(userEntity.getPassword());

        userEntity.setPassword(hashedPassword);

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return savedUserEntity != null;
    }

    public Set<MovieEntity> addMovieToFavList(Long userId, Long movieId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return null;
        }

        Set<MovieEntity> favList = user.getFavList();
        favList.add(movie);

        user.setFavList(favList);

        userRepository.save(user);

        return favList;
    }

    public Set<MovieEntity> addMovieToWatchList(Long userId, Long movieId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        MovieEntity movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return null;
        }

        Set<MovieEntity> watchList = user.getWatchList();
        watchList.add(movie);

        user.setWatchList(watchList);

        userRepository.save(user);

        return watchList;
    }

    public UserEntity deleteUserByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
