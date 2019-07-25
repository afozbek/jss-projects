package com.obss.movietracker.springwebservice.Model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Map<Long, MovieEntity> favList;

    @ElementCollection
    private Map<Long, MovieEntity> watchList;

    @Column
    private boolean isAdmin;


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
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

    public Map<Long, MovieEntity> getFavList() {
        return favList;
    }

    public void setFavList(Map<Long, MovieEntity> favList) {
        this.favList = favList;
    }

    public Map<Long, MovieEntity> getWatchList() {
        return watchList;
    }

    public void setWatchList(Map<Long, MovieEntity> watchList) {
        this.watchList = watchList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
