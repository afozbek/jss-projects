package com.obss.movietracker.springwebservice.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private boolean status;

    @ElementCollection
    private Set<MovieEntity> favList;

    @ElementCollection
    private Set<MovieEntity> watchList;

    @Column
    private boolean isAdmin;

    public UserEntity() {
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEntity(String email, String password, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserEntity(String email, String firstName, String lastName, String password, boolean isAdmin) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserEntity(String email, String firstName, String lastName, String password, boolean status, Set<MovieEntity> favList, Set<MovieEntity> watchList, boolean isAdmin) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.status = status;
        this.favList = favList;
        this.watchList = watchList;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", favList=" + favList +
                ", watchList=" + watchList +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public Set<MovieEntity> getWatchList() {
        return watchList;
    }

    public void setWatchList(Set<MovieEntity> watchList) {
        this.watchList = watchList;
    }

    public Set<MovieEntity> getFavList() {
        return favList;
    }

    public void setFavList(Set<MovieEntity> favList) {
        this.favList = favList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
